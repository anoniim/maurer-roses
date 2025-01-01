@file:Suppress("RedundantNullableReturnType", "RedundantSuppression")
package net.solvetheriddle.openrndr.maurer

import net.solvetheriddle.openrndr.maurer.bank.SeedBank
import net.solvetheriddle.openrndr.maurer.styles.ShadeStyles
import net.solvetheriddle.openrndr.maurer.ui.*
import net.solvetheriddle.openrndr.maurer.ui.Display
import org.openrndr.*
import org.openrndr.animatable.Animatable
import org.openrndr.animatable.easing.Easing
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.ShadeStyle
import org.openrndr.draw.colorBuffer
import org.openrndr.draw.isolated
import org.openrndr.draw.loadImage
import org.openrndr.extensions.Screenshots
import org.openrndr.extra.fx.color.LumaOpacity
import org.openrndr.ffmpeg.ScreenRecorder
import org.openrndr.math.Vector2
import org.openrndr.math.asRadians
import org.openrndr.panel.ControlManager
import org.openrndr.panel.elements.*
import org.openrndr.panel.layout
import org.openrndr.shape.ShapeContour
import org.openrndr.shape.contour
import kotlin.math.*
import kotlin.properties.Delegates

// sketch config
private val useDisplay = Display.MACBOOK_SQUARE
private const val enableScreenshots = false // on SPACE, disables rose animations
private const val enableScreenRecording = false // automatically hides UI when enabled
private const val seedBankName = "squareWall" // showcase, playground, squareWall, winter24_1
private const val showUi = true

// config background
private val roseBackgroundColor = ColorRGBa.BLACK
private val backgroundImagePath: String? = null // "data/images/snowflake21.jpeg" // null
private const val backgroundImageFadeOutDuration = 60 * 3 // 0.0 to turn off
private fun backgroundShadeStyle() = null // ShadeStyles.snowflake21 // greenVioletLinear

// config rose stroke, color, fill
private const val lineOpacity = 0.9 // 0.6
private const val allowPartialShapes = true // true for smoother animations and cut-off stills; false for flashy animations and complete stills
private val roseStrokeColor = ColorRGBa.WHITE // TRANSPARENT
private fun fillShadeStyle() = ShadeStyles.beautifulFlower

// config animations
private const val fadeOutBackgroundAutomatically = false
private const val revealDuration = 60 * 7.0 // seconds
private const val strokeFadeOutDuration = 60 * 3.0 // seconds
private const val animationDuration = 5_000L // milliseconds

/**
 * This program draws and animates Maurer Rose - https://en.wikipedia.org/wiki/Maurer_rose.
 *

 */
@Suppress("GrazieInspection")
fun main() {
    application {
        configure {
            sketchSize(useDisplay)
        }
        program {
            // RECORD
            setupScreenshotsIfEnabled()
            setupScreenRecordingIfEnabled()

            // DRAW
            drawBackgroundIfSet(backgroundShadeStyle())
            drawBackgroundImageIfSet(backgroundImagePath)
            drawRose(rose)

            // ANIMATE
            enableBackgroundFadeOutAnimations()
            enableVisibilityAnimations()
            enableRoseAnimations()

            // UI
            enableSeedView()
            addUiIfEnabled()
            enableKeyboardControls()

            // TODO add WindowedGUI
        }
    }
}

private fun Program.drawBackgroundIfSet(shadeStyle: ShadeStyle?) {
    extend {
        @Suppress("SENSELESS_COMPARISON", "KotlinRedundantDiagnosticSuppress") // static configuration
        if (shadeStyle != null) {
            drawer.clear(roseBackgroundColor)
            drawer.stroke = null
            drawer.shadeStyle = shadeStyle
            drawer.rectangle(0.0, 0.0, drawer.bounds.width, drawer.bounds.height)
            drawer.shadeStyle = null
        } else {
            drawer.clear(roseBackgroundColor)
        }
    }
}

private fun Program.drawRose(rose: MaurerRose) {
    extend {
        drawer.isolated {
            drawer.translate(drawer.bounds.center)
            drawer.translate(0.0, 6.0)
            rose.draw()
            rose.updateAnimation()
        }
    }
}

private fun Program.drawBackgroundImageIfSet(backgroundImagePath: String?) {
    if (backgroundImagePath != null) {
        val backgroundImage = BackgroundImage(backgroundImagePath)
        extend {
            val image = applyFadeFilterIfNeeded(backgroundImage)
            drawer.image(
                image, 0.0, 0.0,
                width = backgroundImage.image.width.toDouble(),
                height = backgroundImage.image.height.toDouble()
            )
        }
    }
}

private fun Program.applyFadeFilterIfNeeded(backgroundImage: BackgroundImage) =
    when (backgroundVisibility) {
        BackgroundVisibility.VISIBLE -> backgroundImage.image
        else -> {
            applyFadeFilter(backgroundImage, frameCount)
            backgroundImage.filtered
        }
    }

private fun applyFadeFilter(image: BackgroundImage, frameCount: Int) {
    with(image.filter) {
        if (frameCount - backgroundVisibilityChangeFrame < backgroundImageFadeOutDuration) {
            val alpha = (frameCount - backgroundVisibilityChangeFrame) * (PI / 2.0) / backgroundImageFadeOutDuration
            if (backgroundVisibility == BackgroundVisibility.FADE_OUT) {
                backgroundOpacity = cos(alpha)
                foregroundOpacity = cos(alpha)
            } else if (backgroundVisibility == BackgroundVisibility.FADE_IN) {
                backgroundOpacity = sin(alpha)
                foregroundOpacity = sin(alpha)
            }
            apply(image.image, image.filtered)
        }
    }
}

class BackgroundImage(imagePath: String) {
    val image = loadImage(imagePath)
    val filter = LumaOpacity()
    val filtered = colorBuffer(image.width, image.height)
}

private val rose = MaurerRose()
private val bank = SeedBank(seedBankName) { nValue, dValue -> rose.set(nValue, dValue) }
private val initialN = bank.seeds[bank.selectedSeed].nValue
private val initialD = bank.seeds[bank.selectedSeed].dValue // For AnimationConfig.AX = 3.1

private class MaurerRose : Animatable() {

    // number of petals
    var n: Double by Delegates.observable(initialN) { _, _, newValue ->
        if (::nSlider.isInitialized) nSlider.value = newValue
        if (::screenshots.isInitialized) screenshots.updateName(n = newValue)
    }

    // angle factor
    var d: Double by Delegates.observable(initialD) { _, _, newValue ->
        if (::dSlider.isInitialized) dSlider.value = newValue
        if (::screenshots.isInitialized) screenshots.updateName(d = newValue)
    }

    fun set(nValue: Double, dValue: Double) {
        n = nValue
        d = dValue
    }

    fun animate(targetNValue: Double, targetDValue: Double, duration: Long, predelay: Long = 0, easing: Easing = Easing.CubicInOut) {
        ::n.animate(targetNValue, duration, easing, predelay)
        ::d.animate(targetDValue, duration, easing, predelay)
    }

    context(Program)
    fun draw() {
        drawer.shadeStyle = if (fillEnabled) fillShadeStyle() else null
        drawer.stroke = getStroke()
        val contour = shapeContour()
        if (!contour.empty) drawer.contour(contour)
    }

    private fun Program.getStroke(): ColorRGBa {
        val animationDuration = if (backgroundVisibility != BackgroundVisibility.VISIBLE) backgroundImageFadeOutDuration.toDouble() else strokeFadeOutDuration
        return when (strokeVisibility) {
            StrokeVisibility.FADE_OUT -> roseStrokeColor.opacify(lineOpacity - (frameCount - visibilityChangeFrame) / animationDuration)
            StrokeVisibility.FADE_IN -> roseStrokeColor.opacify(min(lineOpacity, (frameCount - visibilityChangeFrame) / animationDuration))
            else -> roseStrokeColor.opacify(lineOpacity)
        }
    }

    private fun Program.shapeContour(): ShapeContour {
        val c = if (fillEnabled) {
            if (allowPartialShapes) fillableIncompleteShapeContour() else fillableCompleteShapeContour()
        } else lineShapeContour()
        return when (reveal) {
            Reveal.GRADUAL_IN -> c.sampleEquidistant(10_000).sub(0.0, min((frameCount - revealChangeFrame) / revealDuration, 1.0))
            Reveal.GRADUAL_OUT -> c.sampleEquidistant(10_000).sub(1.0, max((frameCount - revealChangeFrame) / revealDuration, 0.0))
            else -> c
        }
    }

    private fun Program.fillableIncompleteShapeContour(): ShapeContour {
        return lineShapeContour().close()
    }

    private fun Program.lineShapeContour(): ShapeContour = contour {
        val radius = drawer.height / 2.0 * zoom
        val firstPoint = getPointForAngle(0, radius)
        moveTo(firstPoint)
        val numOfConnectedPoints = 360
        for (angle in 0..numOfConnectedPoints) {
            val nextPoint = getPointForAngle(angle, radius)
            if (curvesEnabled) continueTo(nextPoint) else lineTo(nextPoint)
        }
    }

    private fun Program.fillableCompleteShapeContour(): ShapeContour {
        val radius = drawer.height / 2.0 * zoom
        var angle = 0
        var nextPoint = getPointForAngle(0, radius)
        val rosePoints = mutableListOf(nextPoint)
        do {
            angle++
            nextPoint = getPointForAngle(angle, radius)
            rosePoints.add(nextPoint)
        } while (!(angle > 360 && nextPoint.distanceTo(Vector2.ZERO) < 10.0))

        // TODO Add support for curves j
        return ShapeContour.fromPoints(rosePoints, true)
    }

    private fun getPointForAngle(angle: Int, radius: Double): Vector2 {
        val k = angle * d.asRadians
        val r = radius * sin(n * k)
        val x = r * cos(k)
        val y = r * sin(k)
        return Vector2(x, y)
    }
}

private enum class BackgroundVisibility {
    VISIBLE, FADE_OUT, FADE_IN
}

private enum class StrokeVisibility {
    VISIBLE, FADE_OUT, FADE_IN
}

private enum class Reveal {
    REVEALED, GRADUAL_IN, GRADUAL_OUT
}

private var backgroundVisibilityChangeFrame = 0

@Suppress("KotlinConstantConditions")
private var backgroundVisibility = when {
    fadeOutBackgroundAutomatically -> BackgroundVisibility.FADE_OUT
    else -> BackgroundVisibility.VISIBLE
}

private fun Program.enableBackgroundFadeOutAnimations() {
    executeOnKey("-") {
        backgroundVisibilityChangeFrame = frameCount
        backgroundVisibility = BackgroundVisibility.FADE_OUT
    }
    executeOnKey("=") {
        backgroundVisibilityChangeFrame = frameCount
        backgroundVisibility = BackgroundVisibility.FADE_IN
        strokeVisibility = StrokeVisibility.FADE_OUT
    }
}

private var strokeVisibility = when {
    fadeOutBackgroundAutomatically -> StrokeVisibility.FADE_IN
    else -> StrokeVisibility.VISIBLE
}
private var reveal = Reveal.REVEALED
private var visibilityChangeFrame = 0
private var revealChangeFrame = 0

private fun Program.enableRoseAnimations() {
    executeOnKey("left-shift") {
        val targetSeedIndex = max(bank.selectedSeed - 1, 0)
        animateToTarget(targetSeedIndex)
    }
    executeOnKey("right-shift") {
        val targetSeedIndex = min(bank.selectedSeed + 1, bank.seeds.lastIndex)
        animateToTarget(targetSeedIndex)
    }
    if (!enableScreenshots) executeOnKey("space") {
        val firstTarget = bank.selectedSeed + 1
        bank.seeds.subList(firstTarget, bank.seeds.size)
            .filter { it.isNotEmpty() }
            .forEachIndexed { index, _ ->
                animateToTarget(firstTarget + index, index * animationDuration)
            }
    }
    onCmdNumberKeys { animateToTarget(it) }
}

private val animationEasing = Easing.CubicInOut
private fun animateToTarget(targetSeedIndex: Int, predelay: Long = 0L) {
    val targetSeed = bank.seeds[targetSeedIndex]
    rose.animate(targetSeed.nValue, targetSeed.dValue, animationDuration, predelay, easing = animationEasing)
    bank.selectedSeed = targetSeedIndex
}

private fun Program.enableVisibilityAnimations() {
    executeOnKey("[") {
        strokeVisibility = StrokeVisibility.FADE_OUT
        visibilityChangeFrame = frameCount
    }
    executeOnKey("]") {
        strokeVisibility = StrokeVisibility.FADE_IN
        reveal = Reveal.REVEALED
        visibilityChangeFrame = frameCount
    }
    executeOnKey("\\") {
        reveal = Reveal.GRADUAL_IN
        strokeVisibility = StrokeVisibility.VISIBLE
        revealChangeFrame = frameCount
    }
    executeOnKey("'") {
        reveal = Reveal.GRADUAL_OUT
        revealChangeFrame = frameCount
    }
}

fun Program.enableSeedView() {
    onFKeys { group -> bank.setGroup(group) }
    executeOnKey("§") { bank.toggleEditMode() }
    onNumberKeys { slot -> bank.setSlot(slot, rose.n, rose.d) }
    bank.loadFonts()
    if (showUi && !enableScreenRecording) extend {
        bank.drawUi()
    }
}

private lateinit var nSlider: Slider
private lateinit var dSlider: Slider

private fun Program.addUiIfEnabled() {
    if (showUi && !enableScreenRecording) extend(ControlManager()) {
        layout {
            addNSlider()
            addDSlider()
            addCurvesButton()
            addFillButton()
            // TODO add Stroke button
        }
    }
}

private fun Body.addNSlider() {
    nSlider = slider {
        label = "n"
        range = Range(0.0, 300.0)
        value = initialN
        precision = 6
        events.valueChanged.listen {
            rose.n = it.newValue
        }
    }
}

private fun Body.addDSlider() {
    dSlider = slider {
        label = "d"
        range = Range(0.0, 300.0)
        value = initialD
        precision = 6
        events.valueChanged.listen {
            rose.d = it.newValue
        }
    }
}

private var curvesEnabled = false

private fun Body.addCurvesButton() {
    button {
        fun getCurvesButtonLabel() = if (curvesEnabled) "Curves ON" else "Curves OFF"
        label = getCurvesButtonLabel()
        events.clicked.listen {
            curvesEnabled = !curvesEnabled
            label = getCurvesButtonLabel()
        }
    }
}

private var fillEnabled = false

private fun Body.addFillButton() {
    button {
        fun getFillButtonLabel() = if (fillEnabled) "Fill ON" else "Fill OFF"
        label = getFillButtonLabel()
        events.clicked.listen {
            fillEnabled = !fillEnabled
            label = getFillButtonLabel()
        }
    }
}

private fun Program.enableKeyboardControls() {
    onKeyEvent { keyEvent -> keyEvent.mapAsdfKeyRow { rose.n += it } }
    onKeyEvent { keyEvent -> keyEvent.mapZxcvKeyRow { rose.d += it } }
    setupZoomControl()
}

private var zoom = 0.95

fun Program.setupZoomControl() {
    mouse.buttonUp.listen {
        if (it.button == MouseButton.CENTER) {
            zoom = 0.95
        }
    }
    val scrollSpeedDampening = 50
    mouse.scrolled.listen {
        zoom += it.rotation.y / scrollSpeedDampening
    }
    onKeyEvent {
        if (it.modifiers.contains(KeyModifier.SUPER) && it.name == "+") zoom += 0.1
        if (it.modifiers.contains(KeyModifier.SUPER) && it.name == "-") zoom -= 0.1
    }
}

private fun Program.onKeyEvent(setValue: (KeyEvent) -> Unit) {
    keyboard.keyRepeat.listen(setValue)
    keyboard.keyDown.listen(setValue)
}

private fun Program.setupScreenRecordingIfEnabled() {
    if (enableScreenRecording) {
        extend(ScreenRecorder()) {
            name = "maurer_rose_vid_$seedBankName-${bank.selectedSeedGroup.inc()}"
            frameRate = 60
        }
    }
}

private lateinit var screenshots: RoseScreenshots

private fun Program.setupScreenshotsIfEnabled() {
    if (enableScreenshots) {
        screenshots = RoseScreenshots()
        extend(screenshots)
    }
}

private class RoseScreenshots : Screenshots() {

    private val customFolderName = "screenshots/maurer_roses"

    init {
        name = "$customFolderName/rose_${rose.d}-${rose.n}.png"
    }

    fun updateName(n: Double? = null, d: Double? = null) {
        val newN = n ?: rose.n
        val newD = d ?: rose.d
        name = "$customFolderName/rose_$newD-$newN.png"
    }
}
