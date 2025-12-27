package net.solvetheriddle.openrndr.maurer.bank

import org.openrndr.Program
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.isolated
import org.openrndr.draw.loadFont
import org.openrndr.extra.color.presets.DARK_GREY
import org.openrndr.extra.color.presets.DARK_RED
import org.openrndr.extra.color.presets.GREY
import java.io.File

class SeedBank(
    private val seedBankName: String,
    private val setRose: (Double, Double) -> Unit,
) {

    private var editMode = false

    var selectedSeedGroup = 0
        private set
    var selectedSeed = 0
    private val seedBankFile = File("data/maurer_roses_store/$seedBankName").apply { createNewFile() }
    private lateinit var comments: MutableList<String>
    private val seedBank = loadSeeds().toMutableList()
    var seeds = seedBank[selectedSeedGroup].toMutableList()

    private fun newSeedBank(): List<List<RoseSeed>> = List(12) { List(9) { RoseSeed.Empty } }
    private fun List<RoseSeed>.isGroupEmpty() = all { seed -> !seed.isNotEmpty() }

    private lateinit var extraSmallFont: FontImageMap
    private lateinit var mediumFont: FontImageMap
    private lateinit var smallFont: FontImageMap
    private lateinit var bigFont: FontImageMap

    private fun MutableList<RoseSeed>.isNotAllZeros() = any { seed -> seed.isNotEmpty() }

    private fun loadSeeds(): List<List<RoseSeed>> {
        val loadedSeedBank = seedBankFile.readLines().mapIndexed { index, line ->
            val lineWithoutComments = extractComments(line, index)
            lineWithoutComments.split(";").map(RoseSeed::fromString)
        }
        return if (loadedSeedBank.size >= 12) loadedSeedBank else newSeedBank()
    }

    private fun extractComments(line: String, index: Int): String = if (line.contains("//")) {
        if (!this::comments.isInitialized) {
            comments = mutableListOf("")
        }
        fillGapsInCommentsIfNeeded(index)
        val indexOfCommentSymbol = line.indexOf("//")
        comments[index] = line.substring(indexOfCommentSymbol)
        line.removeRange(startIndex = indexOfCommentSymbol, endIndex = line.lastIndex)
    } else line

    private fun readSeed(slot: Int) {
        selectedSeed = slot
        fillGapsInSeedsIfNeeded(slot)
        setRose(seeds[slot].nValue, seeds[slot].dValue)
    }

    private fun writeSeed(slot: Int, nValue: Double, dValue: Double) {
        selectedSeed = slot
        val seed = RoseSeed(nValue, dValue)
        fillGapsInSeedsIfNeeded(slot)
        seeds[slot] = seed
        seedBank[selectedSeedGroup] = seeds
        seedBankFile.write(seedBank, comments)
    }

    private fun fillGapsInSeedsIfNeeded(slot: Int) {
        while (seeds.size <= slot) {
            seeds.add(RoseSeed.Empty)
        }
    }

    private fun fillGapsInCommentsIfNeeded(slot: Int) {
        while (comments.size <= slot) {
            comments.add("")
        }
    }

    private fun File.write(seedBank: List<List<RoseSeed>>, comments: MutableList<String>) {
        val serializedBank = buildString {
            seedBank.forEachIndexed { index, seeds ->
                append("F${index + 1} ___")
                seeds.forEachIndexed { index, seed ->
                    append(" ${index + 1}: ${seed.nValue},${seed.dValue};")
                }
                fillGapsInCommentsIfNeeded(index)
                append(comments[index])
                append('\n')
            }
        }
        writeText(serializedBank)
    }

    private fun Program.drawSeedGroup(topMargin: Double) {
        with(drawer) {
            isolated {
                translate(20.0, topMargin)
                fill = if (editMode) ColorRGBa.DARK_RED else ColorRGBa.GREY
                circle(0.0, 0.0, 12.0)
                fill = backgroundColor
                fontMap = extraSmallFont
                text("F${selectedSeedGroup + 1}", -7.0, 3.0)
                fill = ColorRGBa.GREY
                fontMap = mediumFont
                text(seedBankName, 18.0, 5.0)
            }
        }
    }

    private fun Program.drawSeed(slot: Int, nValue: Double, dValue: Double, topMargin: Double) {
        with(drawer) {
            isolated {
                translate(10.0, topMargin + 45.0 + slot * 40.0)
                fill = if (selectedSeed == slot) ColorRGBa.DARK_GREY else ColorRGBa.GREY
                fontMap = bigFont
                text((slot + 1).toString(), 0.0, 0.0)
                if (editMode) {
                    fontMap = smallFont
                    text("N: $nValue", 28.0, -15.0)
                    text("D: $dValue", 28.0, 0.0)
                }
            }
        }
    }

    fun setGroup(group: Int) {
        selectedSeedGroup = group
        selectedSeed = 0
        seeds = seedBank[selectedSeedGroup].toMutableList()
        if (seeds.isNotAllZeros()) {
            setRose(seeds[0].nValue, seeds[0].dValue)
        }
    }

    fun setSlot(slot: Int, nValue: Double, dValue: Double) {
        if (editMode) {
            writeSeed(slot, nValue, dValue)
            editMode = false
        } else readSeed(slot)
    }

    fun toggleEditMode() {
        editMode = !editMode
    }

    context(program: Program)
    fun drawUi() {
        val topMargin = 185.0
        program.drawSeedGroup(topMargin)
        seeds.forEachIndexed { index, seed ->
            if (seed.isNotEmpty()) program.drawSeed(index, seed.nValue, seed.dValue, topMargin)
        }
    }

    context(program: Program)
    fun loadFonts() {
        extraSmallFont = program.loadFont("data/fonts/Rowdies-Light.ttf", 11.0)
        smallFont = program.loadFont("data/fonts/Rowdies-Light.ttf", 12.0)
        mediumFont = program.loadFont("data/fonts/Rowdies-Light.ttf", 18.0)
        bigFont = program.loadFont("data/fonts/Rowdies-Bold.ttf", 40.0)
    }

    fun removeCurrentSeed() {
        seeds.removeAt(selectedSeed)
        seedBank[selectedSeedGroup] = seeds
        seedBankFile.write(seedBank, comments)
        toggleEditMode()
    }
}
