package net.solvetheriddle.openrndr.maurer.styles

import org.openrndr.color.ColorRGBa
import org.openrndr.extra.color.presets.*
import org.openrndr.extra.shadestyles.NPointRadialGradient
import org.openrndr.extra.shadestyles.linearGradient

object ShadeStyles {

    val subtleEdges = NPointRadialGradient(
        arrayOf(
            ColorRGBa.MAROON.opacify(0.0),
            ColorRGBa.MAROON.opacify(0.3),
            ColorRGBa.MAGENTA.opacify(0.5),
            ColorRGBa.YELLOW.opacify(0.5),
        ), points = arrayOf(0.5, 0.8, 0.9, 1.0)
    )

    val unstableGrowth = NPointRadialGradient(
        arrayOf(
            ColorRGBa.SADDLE_BROWN.opacify(0.9),
            ColorRGBa.SEA_GREEN.opacify(0.5),
            ColorRGBa.BLACK.opacify(0.0),
            ColorRGBa.BLACK.opacify(0.0),
            ColorRGBa.PALE_VIOLET_RED.opacify(0.5),
            ColorRGBa.YELLOW.opacify(0.8),
        ), points = arrayOf(0.0, 0.2, 0.4, 0.6, 0.9, 1.0)
    )

    val bloomingHerb = NPointRadialGradient(
        arrayOf(
            ColorRGBa.FOREST_GREEN.opacify(0.9),
            ColorRGBa.LIME_GREEN.opacify(0.5),
            ColorRGBa.GREEN_YELLOW.opacify(0.9),
            ColorRGBa.YELLOW.opacify(0.9),
            ColorRGBa.MEDIUM_VIOLET_RED.opacify(0.9),
            ColorRGBa.DARK_VIOLET.opacify(0.8),
        ), points = arrayOf(0.0, 0.1, 0.3, 0.6, 0.9, 1.0)
    )

    val beautifulFlower = NPointRadialGradient(
        arrayOf(
            ColorRGBa.LIME_GREEN.opacify(0.8),
            ColorRGBa.GREEN_YELLOW.opacify(0.8),
            ColorRGBa.YELLOW.opacify(0.9),
            ColorRGBa.MEDIUM_VIOLET_RED.opacify(0.9),
            ColorRGBa.DARK_RED.opacify(0.8),
            ColorRGBa.DARK_VIOLET.opacify(0.8),
        ), points = arrayOf(0.0, 0.1, 0.3, 0.6, 0.9, 1.0)
    )

    val blackFlower = NPointRadialGradient(
        arrayOf(
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.YELLOW.opacify(0.9),
            ColorRGBa.YELLOW.opacify(0.7),
            ColorRGBa.ORANGE.opacify(0.6),
            ColorRGBa.ORANGE_RED.opacify(0.4),
            ColorRGBa.DARK_RED.opacify(0.2),
            ColorRGBa.BLACK.opacify(1.0),
        ), points = arrayOf(0.0, 0.2, 0.45, 0.55, 0.8, 0.9, 0.96)
    )

    val yellowAura = NPointRadialGradient(
        arrayOf(
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.YELLOW.opacify(0.7),
            ColorRGBa.YELLOW.opacify(0.2),
            ColorRGBa.BLACK.opacify(1.0),
        ), points = arrayOf(0.0, 0.5, 0.7, 0.96)
    )

    val yellowAuraSmall = NPointRadialGradient(
        arrayOf(
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.YELLOW.opacify(0.7),
            ColorRGBa.YELLOW.opacify(0.2),
            ColorRGBa.BLACK.opacify(1.0),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val yellowAuraWhiteFrame = NPointRadialGradient(
        arrayOf(
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.BLACK.opacify(1.0),
            ColorRGBa.YELLOW.opacify(0.7),
            ColorRGBa.YELLOW.opacify(1.0),
            ColorRGBa.WHITE.opacify(1.0),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val greenVioletLinear = linearGradient(
        ColorRGBa.LIME_GREEN,
        ColorRGBa.BLUE_VIOLET,
        rotation = 300.0
    )

    val snowflake1 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.GOLD.opacify(0.7),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
            ColorRGBa.SKY_BLUE.opacify(0.6),
            ColorRGBa.SKY_BLUE.opacify(1.0),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake2 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
            ColorRGBa.TURQUOISE.opacify(0.5),
            ColorRGBa.LIGHT_PINK.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake3 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.DARK_TURQUOISE.opacify(0.8),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake4 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.PALE_VIOLET_RED.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.DARK_RED.opacify(0.3),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake5 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.BLUE.opacify(0.1),
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SEA_GREEN.opacify(0.4),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3),
            ColorRGBa.MEDIUM_TURQUOISE.opacify(0.4),
        ), points = arrayOf(0.0, 0.3, 0.6, 0.76)
    )

    val snowflake6 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.DARK_GREEN.opacify(0.3),
            ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake7 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.YELLOW.opacify(0.5),
            ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.DODGER_BLUE.opacify(0.8),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.2),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake8 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.DARK_GREEN.opacify(0.3),
            ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake9 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.WHITE_SMOKE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3),
            ColorRGBa.DARK_GREEN.opacify(0.6),
            ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake10 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.DEEP_SKY_BLUE.opacify(0.6),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3),
            ColorRGBa.DARK_ORANGE.opacify(0.6),
            ColorRGBa.NAVAJO_WHITE.opacify(0.5),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake11 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.WHITE_SMOKE.opacify(0.9),
            ColorRGBa.SKY_BLUE.opacify(0.3),
            ColorRGBa.NAVAJO_WHITE.opacify(0.5),
            ColorRGBa.GOLD.opacify(0.3),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.76)
    )

    val snowflake12 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.NAVAJO_WHITE.opacify(0.5),
            ColorRGBa.CORAL.opacify(0.3),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0),
            ColorRGBa.WHITE_SMOKE.opacify(0.9),
            ColorRGBa.SEA_GREEN.opacify(0.4),
        ), points = arrayOf(0.0, 0.6, 0.7, 0.86)
    )

    val snowflake13 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(0.9),
            ColorRGBa.PALE_VIOLET_RED.opacify(0.5),
            ColorRGBa.DARK_RED.opacify(0.5),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.8),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(1.0),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.8),
        ), points = arrayOf(0.0, 0.4, 0.75, 0.8, 0.86)
    )

    val snowflake14 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.YELLOW.opacify(0.5),
            ColorRGBa.DARK_RED.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.PALE_VIOLET_RED.opacify(0.5),
            ColorRGBa.DODGER_BLUE.opacify(0.8),
            ColorRGBa.DARK_BLUE.opacify(0.4),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.2),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.6, 0.74, 0.86)
    )

    val snowflake15 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.YELLOW.opacify(0.7),
            ColorRGBa.TURQUOISE.opacify(0.5),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.YELLOW.opacify(0.5),
            ColorRGBa.DARK_TURQUOISE.opacify(0.6),
            ColorRGBa.TURQUOISE.opacify(0.4),
            ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5),
        ), points = arrayOf(0.0, 0.3, 0.5, 0.6, 0.74, 0.9)
    )

    val snowflake16 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.SADDLE_BROWN.opacify(0.7),
            ColorRGBa.NAVAJO_WHITE.opacify(0.5),
            ColorRGBa.FOREST_GREEN.opacify(0.5),
            ColorRGBa.ORANGE.opacify(0.6),
            ColorRGBa.NAVAJO_WHITE.opacify(0.4),
        ), points = arrayOf(0.0, 0.6, 0.7, 0.84, 0.95)
    )

    val snowflake17 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.ROYAL_BLUE.opacify(0.7),
            ColorRGBa.WHITE_SMOKE.opacify(0.5),
            ColorRGBa.DODGER_BLUE.opacify(0.5),
            ColorRGBa.DARK_ORANGE.opacify(0.3),
            ColorRGBa.BLUE_STEEL.opacify(0.4),
        ), points = arrayOf(0.0, 0.6, 0.7, 0.9, 0.98)
    )

    val snowflake18 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.ORANGE_RED.opacify(0.7),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.LIGHT_SEA_GREEN.opacify(0.4),
            ColorRGBa.DARK_ORANGE.opacify(0.3),
            ColorRGBa.NAVAJO_WHITE.opacify(0.2),
        ), points = arrayOf(0.0, 0.4, 0.7, 0.78)
    )

    val snowflake19 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.ORANGE_RED.opacify(0.7),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.CRIMSON.opacify(0.4),
            ColorRGBa.DARK_ORANGE.opacify(0.3),
            ColorRGBa.NAVAJO_WHITE.opacify(0.2),
        ), points = arrayOf(0.0, 0.4, 0.7, 0.78)
    )

    val snowflake20 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.DARK_GREEN.opacify(0.4),
            ColorRGBa.PALE_TURQUOISE.opacify(0.6),
            ColorRGBa.CRIMSON.opacify(0.4),
            ColorRGBa.FLORAL_WHITE.opacify(0.3),
            ColorRGBa.DARK_ORANGE.opacify(0.3),
            ColorRGBa.NAVAJO_WHITE.opacify(0.3),
        ), points = arrayOf(0.0, 0.6, 0.7, 0.78, 0.84, 0.91)
    )

    val snowflake21 = NPointRadialGradient(
        arrayOf(
            ColorRGBa.WHITE_SMOKE.opacify(0.3),
            ColorRGBa.DARK_GREEN.opacify(0.4),
            ColorRGBa.DARK_OLIVE_GREEN.opacify(0.5),
            ColorRGBa.DARK_ORANGE.opacify(0.3),
            ColorRGBa.PALE_TURQUOISE.opacify(0.6),
            ColorRGBa.CRIMSON.opacify(0.4),
            ColorRGBa.NAVAJO_WHITE.opacify(0.3),
        ), points = arrayOf(0.0, 0.6, 0.7, 0.78, 0.84, 0.91)
    )
}