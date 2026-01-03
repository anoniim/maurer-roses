@file:Suppress("unused")

package net.solvetheriddle.openrndr.maurer.ui

import org.openrndr.Configuration
import org.openrndr.Fullscreen
import org.openrndr.math.IntVector2

fun Configuration.sketchSize(config: SketchSizeConfig) {
    if (config is Display) {
        width = config.width
        height = config.height
        position = IntVector2(config.xPosition, config.yPosition)

    } else if (config == Display.FULLSCREEN) {
        fullscreen = Fullscreen.CURRENT_DISPLAY_MODE
    }
}

interface SketchSizeConfig

enum class Display(val width: Int, val height: Int, val xPosition: Int, val yPosition: Int = 0): SketchSizeConfig {
    LG_ULTRAWIDE(2560, 1550, 1280),
    LG_ULTRAWIDE_LEFT(2560, 1550, 0),
    LG_SQUARE_LEFT(1080, 1080, 100, (LG_ULTRAWIDE.height - 1080) / 2),
    LG_SQUARE_RIGHT(LG_ULTRAWIDE.height, LG_ULTRAWIDE.height, 3840 - LG_ULTRAWIDE.height),
    LG_PORTRAIT_LEFT(630, 1305, 325, (LG_ULTRAWIDE.height - 1305) / 2),
    MACBOOK_AIR(1500, 997, 500),
    MACBOOK_SQUARE(1100,1100,700),

    PRINT_A6(1485,1050,0),
    PRINT_SQUARE_SMALL(1536,1536,0), // 10x10cm prints

    // Prints in 300PPI formula: ([mm]/25.4)*300

    PRINT_60CM_SQUARE_PRINT(7_087, 7_087, 0), // 60x60cm with 300PPI
    PRINT_20X60CM_PRINT(2_362,7_087,0), // 20x60cm with 300PPI

    PRINT_A1_PORTRAIT(7_016, 9_933, 0), // 594 x 841 mm with 300PPI
    PRINT_A2_PORTRAIT(4_961, 7_016, 0), // 420 x 594 mm with 300PPI
    PRINT_A3_PORTRAIT(3_508, 4_961, 0), // 297 x 420 mm with 300PPI
    ;
    object FULLSCREEN: SketchSizeConfig
}