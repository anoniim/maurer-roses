@file:Suppress("unused")

package net.solvetheriddle.openrndr.maurer.styles

import org.openrndr.color.ColorRGBa
import org.openrndr.extra.color.presets.*
import org.openrndr.extra.shadestyles.fills.gradients.gradient

object ShadeStyles {

    val subtleEdges = gradient<ColorRGBa> {
        radial {
            stops[0.5] = ColorRGBa.MAROON.opacify(0.0)
            stops[0.8] = ColorRGBa.MAROON.opacify(0.3)
            stops[0.9] = ColorRGBa.MAGENTA.opacify(0.5)
            stops[1.0] = ColorRGBa.YELLOW.opacify(0.5)
        }
    }

// ... (rest of the file until yellowWhite)

    val unstableGrowth = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.SADDLE_BROWN.opacify(0.9)
            stops[0.2] = ColorRGBa.SEA_GREEN.opacify(0.5)
            stops[0.4] = ColorRGBa.BLACK.opacify(0.0)
            stops[0.6] = ColorRGBa.BLACK.opacify(0.0)
            stops[0.9] = ColorRGBa.PALE_VIOLET_RED.opacify(0.5)
            stops[1.0] = ColorRGBa.YELLOW.opacify(0.8)
        }
    }

    val bloomingHerb = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.FOREST_GREEN.opacify(0.9)
            stops[0.1] = ColorRGBa.LIME_GREEN.opacify(0.5)
            stops[0.3] = ColorRGBa.GREEN_YELLOW.opacify(0.9)
            stops[0.6] = ColorRGBa.YELLOW.opacify(0.9)
            stops[0.9] = ColorRGBa.MEDIUM_VIOLET_RED.opacify(0.9)
            stops[1.0] = ColorRGBa.DARK_VIOLET.opacify(0.8)
        }
    }

    val beautifulFlower = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.LIME_GREEN.opacify(0.8)
            stops[0.1] = ColorRGBa.GREEN_YELLOW.opacify(0.8)
            stops[0.3] = ColorRGBa.YELLOW.opacify(0.9)
            stops[0.6] = ColorRGBa.MEDIUM_VIOLET_RED.opacify(0.9)
            stops[0.9] = ColorRGBa.DARK_RED.opacify(0.8)
            stops[1.0] = ColorRGBa.DARK_VIOLET.opacify(0.8)
        }
    }

    val blackFlower = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.2] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.45] = ColorRGBa.YELLOW.opacify(0.9)
            stops[0.55] = ColorRGBa.YELLOW.opacify(0.7)
            stops[0.8] = ColorRGBa.ORANGE.opacify(0.6)
            stops[0.9] = ColorRGBa.ORANGE_RED.opacify(0.4)
            stops[0.96] = ColorRGBa.DARK_RED.opacify(0.2)
            stops[1.0] = ColorRGBa.BLACK.opacify(1.0) // Inferred
        }
    }

    val yellowAura = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.5] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.7] = ColorRGBa.YELLOW.opacify(0.7)
            stops[0.96] = ColorRGBa.YELLOW.opacify(0.2)
            stops[1.0] = ColorRGBa.BLACK.opacify(1.0) // Inferred
        }
    }

    val yellowAuraSmall = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.3] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.5] = ColorRGBa.YELLOW.opacify(0.7)
            stops[0.76] = ColorRGBa.YELLOW.opacify(0.2)
            stops[1.0] = ColorRGBa.BLACK.opacify(1.0) // Inferred
        }
    }

    val yellowAuraWhiteFrame = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.3] = ColorRGBa.BLACK.opacify(1.0)
            stops[0.5] = ColorRGBa.YELLOW.opacify(0.7)
            stops[0.76] = ColorRGBa.YELLOW.opacify(1.0)
            stops[1.0] = ColorRGBa.WHITE.opacify(1.0) // Inferred
        }
    }

    val greenVioletLinear = gradient<ColorRGBa> {
        linear {
//            rotation = 300.0
            stops[0.0] = ColorRGBa.LIME_GREEN
            stops[1.0] = ColorRGBa.BLUE_VIOLET
        }
    }

    val snowflake1 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.GOLD.opacify(0.7)
            stops[0.5] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5)
            stops[0.76] = ColorRGBa.SKY_BLUE.opacify(0.6)
            stops[1.0] = ColorRGBa.SKY_BLUE.opacify(1.0) // Inferred
        }
    }

    val snowflake2 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5)
            stops[0.5] = ColorRGBa.TURQUOISE.opacify(0.5)
            stops[0.76] = ColorRGBa.LIGHT_PINK.opacify(0.5)
            stops[1.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0) // Inferred
        }
    }

    val snowflake3 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5)
            stops[0.5] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.76] = ColorRGBa.DARK_TURQUOISE.opacify(0.8)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5) // Inferred
        }
    }

    val snowflake4 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.PALE_VIOLET_RED.opacify(0.5)
            stops[0.5] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.76] = ColorRGBa.DARK_RED.opacify(0.3)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5) // Inferred
        }
    }

    val snowflake5 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLUE.opacify(0.1)
            stops[0.3] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.6] = ColorRGBa.LIGHT_SEA_GREEN.opacify(0.4)
            stops[0.76] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3)
            stops[1.0] = ColorRGBa.MEDIUM_TURQUOISE.opacify(0.4) // Inferred
        }
    }

    val snowflake6 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.5] = ColorRGBa.DARK_GREEN.opacify(0.3)
            stops[0.76] = ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3) // Inferred
        }
    }

    val snowflake7 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.YELLOW.opacify(0.5)
            stops[0.3] = ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5)
            stops[0.5] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.76] = ColorRGBa.DODGER_BLUE.opacify(0.8)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.2) // Inferred
        }
    }

    val snowflake8 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.3] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.5] = ColorRGBa.DARK_GREEN.opacify(0.3)
            stops[0.76] = ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3) // Inferred
        }
    }

    val snowflake9 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.3] = ColorRGBa.WHITE_SMOKE.opacify(1.0)
            stops[0.5] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3)
            stops[0.76] = ColorRGBa.DARK_GREEN.opacify(0.6)
            stops[1.0] = ColorRGBa.MEDIUM_TURQUOISE.opacify(0.5) // Inferred
        }
    }

    val snowflake10 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.3] = ColorRGBa.DEEP_SKY_BLUE.opacify(0.6)
            stops[0.5] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.3)
            stops[0.76] = ColorRGBa.DARK_ORANGE.opacify(0.6)
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.5) // Inferred
        }
    }

    val snowflake11 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.3] = ColorRGBa.WHITE_SMOKE.opacify(0.9)
            stops[0.5] = ColorRGBa.SKY_BLUE.opacify(0.3)
            stops[0.76] = ColorRGBa.NAVAJO_WHITE.opacify(0.5)
            stops[1.0] = ColorRGBa.GOLD.opacify(0.3) // Inferred
        }
    }

    val snowflake12 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.5)
            stops[0.6] = ColorRGBa.CORAL.opacify(0.3)
            stops[0.7] = ColorRGBa.LIGHT_SKY_BLUE.opacify(5.0)
            stops[0.86] = ColorRGBa.WHITE_SMOKE.opacify(0.9)
            stops[1.0] = ColorRGBa.SEA_GREEN.opacify(0.4) // Inferred
        }
    }

    val snowflake13 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(0.9)
            stops[0.4] = ColorRGBa.PALE_VIOLET_RED.opacify(0.5)
            stops[0.75] = ColorRGBa.DARK_RED.opacify(0.5)
            stops[0.8] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.8)
            stops[0.86] = ColorRGBa.LIGHT_SKY_BLUE.opacify(1.0)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.8) // Inferred
        }
    }

    val snowflake14 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.YELLOW.opacify(0.5)
            stops[0.3] = ColorRGBa.DARK_RED.opacify(0.5)
            stops[0.5] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.PALE_VIOLET_RED.opacify(0.5)
            stops[0.74] = ColorRGBa.DODGER_BLUE.opacify(0.8)
            stops[0.86] = ColorRGBa.DARK_BLUE.opacify(0.4)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.2) // Inferred
        }
    }

    val snowflake15 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.YELLOW.opacify(0.7)
            stops[0.3] = ColorRGBa.TURQUOISE.opacify(0.5)
            stops[0.5] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.YELLOW.opacify(0.5)
            stops[0.74] = ColorRGBa.DARK_TURQUOISE.opacify(0.6)
            stops[0.9] = ColorRGBa.TURQUOISE.opacify(0.4)
            stops[1.0] = ColorRGBa.LIGHT_SKY_BLUE.opacify(0.5) // Inferred
        }
    }

    val snowflake16 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.SADDLE_BROWN.opacify(0.7)
            stops[0.7] = ColorRGBa.NAVAJO_WHITE.opacify(0.5)
            stops[0.84] = ColorRGBa.FOREST_GREEN.opacify(0.5)
            stops[0.95] = ColorRGBa.ORANGE.opacify(0.6)
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.4) // Inferred
        }
    }

    val snowflake17 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.ROYAL_BLUE.opacify(0.7)
            stops[0.7] = ColorRGBa.WHITE_SMOKE.opacify(0.5)
            stops[0.9] = ColorRGBa.DODGER_BLUE.opacify(0.5)
            stops[0.98] = ColorRGBa.DARK_ORANGE.opacify(0.3)
            stops[1.0] = ColorRGBa.BLUE_STEEL.opacify(0.4) // Inferred
        }
    }

    val snowflake18 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.ORANGE_RED.opacify(0.7)
            stops[0.4] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.7] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.78] = ColorRGBa.LIGHT_SEA_GREEN.opacify(0.4)
            stops[1.0] = ColorRGBa.DARK_ORANGE.opacify(0.3) // Inferred (Dropped Navajo White or compressed?)
            // Note: You had 6 colors but only 4 points.
            // Mapped: 0->0.0, 1->0.4, 2->0.7, 3->0.78.
            // Remaining 2 colors: DarkOrange(0.3) and NavajoWhite(0.2).
            // I assigned DarkOrange to 1.0. NavajoWhite is unused here to fit logic.
            // Alternatively, if you want all 6 distributed:
            // stops[0.85] = ColorRGBa.DARK_ORANGE.opacify(0.3)
            // stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.2)
        }
    }

// Correction for snowflake18 and 19 (Significant mismatch 6 cols vs 4 points)
// I will distribute the last two manually to valid range.

    val snowflake18Fixed = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.ORANGE_RED.opacify(0.7)
            stops[0.4] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.7] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.78] = ColorRGBa.LIGHT_SEA_GREEN.opacify(0.4)
            stops[0.9] = ColorRGBa.DARK_ORANGE.opacify(0.3) // Inferred
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.2) // Inferred
        }
    }

    val snowflake19 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.ORANGE_RED.opacify(0.7)
            stops[0.4] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.7] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.78] = ColorRGBa.CRIMSON.opacify(0.4)
            stops[0.9] = ColorRGBa.DARK_ORANGE.opacify(0.3) // Inferred
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.2) // Inferred
        }
    }

    val snowflake20 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.DARK_GREEN.opacify(0.4)
            stops[0.7] = ColorRGBa.PALE_TURQUOISE.opacify(0.6)
            stops[0.78] = ColorRGBa.CRIMSON.opacify(0.4)
            stops[0.84] = ColorRGBa.FLORAL_WHITE.opacify(0.3)
            stops[0.91] = ColorRGBa.DARK_ORANGE.opacify(0.3)
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.3) // Inferred
        }
    }

    val snowflake21 = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE_SMOKE.opacify(0.3)
            stops[0.6] = ColorRGBa.DARK_GREEN.opacify(0.4)
            stops[0.7] = ColorRGBa.DARK_OLIVE_GREEN.opacify(0.5)
            stops[0.78] = ColorRGBa.DARK_ORANGE.opacify(0.3)
            stops[0.84] = ColorRGBa.PALE_TURQUOISE.opacify(0.6)
            stops[0.91] = ColorRGBa.CRIMSON.opacify(0.4)
            stops[1.0] = ColorRGBa.NAVAJO_WHITE.opacify(0.3) // Inferred
        }
    }

    val cvBanner = gradient<ColorRGBa> {
        linear {
//            rotation = 280.0
            stops[0.0] = ColorRGBa(0.30, 0.87, 0.15)
            stops[0.5] = ColorRGBa(0.06, 0.54, 0.82)
            stops[1.0] = ColorRGBa(0.73, 0.01, 0.82)
        }
    }

    val blackToCoral = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.BLACK
            stops[0.1] = ColorRGBa.BLACK
            stops[0.20] = ColorRGBa.GREY
            stops[0.45] = ColorRGBa.LIGHT_CORAL.opacify(0.3)
            stops[0.95] = ColorRGBa.WHITE
            stops[1.0] = ColorRGBa.WHITE
        }
    }

    val whiteToRed = gradient<ColorRGBa> {
        radial {
            stops[0.0] = ColorRGBa.WHITE
            stops[0.2] = ColorRGBa.WHITE
            stops[0.30] = ColorRGBa.DARK_ORANGE
            stops[0.6] = ColorRGBa.DARK_ORANGE
            stops[0.7] = ColorRGBa.RED
            stops[1.0] = ColorRGBa.RED
        }
    }

    // 1. Gymnosperm Architecture (Cypress Cone)
    // Logic: Inner woody core -> Rusty protective scales -> Living green foliage tips
    val gymnospermCone = gradient<ColorRGBa> {
        radial {
            // Inner Core: Tan/Wood (Dense and opaque)
            stops[0.0] = ColorRGBa.fromHex("#D2B48C").opacify(1.0)
            stops[0.25] = ColorRGBa.fromHex("#D2B48C").opacify(0.9)

            // Middle Scales: Rust/Sienna (The hard structural shell)
            stops[0.4] = ColorRGBa.fromHex("#A0522D").opacify(0.8)
            stops[0.65] = ColorRGBa.fromHex("#A0522D").opacify(0.7)

            // Outer Foliage: Sea Green (Living tissue, fading out)
            stops[0.8] = ColorRGBa.fromHex("#2E8B57").opacify(0.5)
            stops[0.95] = ColorRGBa.fromHex("#2E8B57").opacify(0.2)

            // Fade to Void
            stops[1.0] = ColorRGBa.fromHex("#050505").opacify(0.0)
        }
    }

    // 2. Antarctic Diapsore (Grass Seed)
    // Logic: Golden ovary (seed) -> Teal protective glumes -> Slate structural spines
    val antarcticSeed = gradient<ColorRGBa> {
        radial {
            // Center: Flaxen Gold (The grain itself)
            stops[0.0] = ColorRGBa.fromHex("#EEDC82").opacify(1.0)
            stops[0.3] = ColorRGBa.fromHex("#EEDC82").opacify(0.8)

            // Middle: Aquamarine/Teal (The husk/glume)
            stops[0.5] = ColorRGBa.fromHex("#66CDAA").opacify(0.7)
            stops[0.75] = ColorRGBa.fromHex("#66CDAA").opacify(0.5)

            // Outer: Dark Slate (The wispy hair grass tips)
            stops[0.9] = ColorRGBa.fromHex("#2F4F4F").opacify(0.3)

            // Fade to Void
            stops[1.0] = ColorRGBa.fromHex("#050505").opacify(0.0)
        }
    }

    // 3. Reproductive Vibrance (Magenta Flower)
    // Logic: Olive/Khaki reproductive center -> Exploding Magenta petals
    val magentaBloom = gradient<ColorRGBa> {
        radial {
            // Center: Olive Green (Carpels)
            stops[0.0] = ColorRGBa.fromHex("#556B2F").opacify(1.0)

            // Ring: Dark Khaki (Stamens/Pollen)
            stops[0.2] = ColorRGBa.fromHex("#BDB76B").opacify(0.9)
            stops[0.3] = ColorRGBa.fromHex("#BDB76B").opacify(0.8)

            // Petals: Deep Magenta (The main attractor)
            stops[0.5] = ColorRGBa.fromHex("#C71585").opacify(0.7)
            stops[0.85] = ColorRGBa.fromHex("#C71585").opacify(0.4)

            // Fade to Void
            stops[1.0] = ColorRGBa.fromHex("#050505").opacify(0.0)
        }
    }

    // 4. The "Bio Transition" (Rust -> Gold -> Teal)
    // Logic: A purely aesthetic transition from dead husk to living seed
    val bioTransition = gradient<ColorRGBa> {
        radial {
            // Start: Rust (Husk)
            stops[0.0] = ColorRGBa.fromHex("#A0522D").opacify(1.0)
            stops[0.1] = ColorRGBa.fromHex("#A0522D").opacify(0.8)

            // Middle: Gold (Seed)
            stops[0.5] = ColorRGBa.fromHex("#EEDC82").opacify(0.8)
            stops[0.6] = ColorRGBa.fromHex("#EEDC82").opacify(0.6)

            // End: Teal (Life/Sprout)
            stops[0.8] = ColorRGBa.fromHex("#66CDAA").opacify(0.5)
            stops[1.0] = ColorRGBa.fromHex("#66CDAA").opacify(0.0)
        }
    }

    //    val foreground = null
    val foreground = bioTransition
//    val foreground = whiteToRed

//        val background = null
    val background = blackToCoral

}