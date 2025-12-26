package net.solvetheriddle.openrndr.maurer.ui

import net.solvetheriddle.openrndr.maurer.curvesEnabled
import net.solvetheriddle.openrndr.maurer.fillEnabled
import net.solvetheriddle.openrndr.maurer.zoom
import org.openrndr.KEY_ESCAPE
import org.openrndr.KeyEvent
import org.openrndr.KeyModifier
import org.openrndr.MouseButton
import org.openrndr.Program
import org.openrndr.panel.elements.*

fun Body.addNSlider(initialN: Double, onValueChanged: (Double) -> Unit): Slider {
    return slider {
        label = "n"
        range = Range(0.0, 30000.0)
        value = initialN
        precision = 6
        events.valueChanged.listen {
            onValueChanged(it.newValue)
        }
    }
}

fun Body.addDSlider(initialD: Double, onValueChanged: (Double) -> Unit): Slider {
    return slider {
        label = "d"
        range = Range(0.0, 30000.0)
        value = initialD
        precision = 6
        events.valueChanged.listen {
            onValueChanged(it.newValue)
        }
    }
}

fun Program.enableKeyboardControls(onNChanged: (Double) -> Unit, onDChanged: (Double) -> Unit, defaultZoom: Double) {
    onKeyEvent { keyEvent -> keyEvent.mapAsdfKeyRow(onNChanged) }
    onKeyEvent { keyEvent -> keyEvent.mapZxcvKeyRow(onDChanged) }
    setupZoomControl(defaultZoom)
}

fun Program.setupZoomControl(defaultZoom: Double) {
    mouse.buttonUp.listen {
        if (it.button == MouseButton.CENTER) {
            zoom = defaultZoom
        }
    }
    val scrollSpeedDampening = 50
    mouse.scrolled.listen {
        zoom += it.rotation.y / scrollSpeedDampening
    }
    onKeyEvent {
        println("Pressed: ${it.modifiers} + ${it.key} (name: ${it.name})")
        if (it.modifiers.contains(KeyModifier.SUPER) && it.name == "+") zoom += 0.1
        if (it.modifiers.contains(KeyModifier.SUPER) && it.name == "-") zoom -= 0.1
        if (it.key == KEY_ESCAPE) zoom = defaultZoom
    }
}

fun KeyEvent.mapAsdfKeyRow(setValue: (Double) -> Unit) {
    when (name) {
        "a" -> setValue(-10.0)
        "s" -> setValue(-1.0)
        "d" -> setValue(-0.01)
        "f" -> setValue(-0.001)
        "g" -> setValue(-0.0005)
        "t" -> setValue(-0.0001)
        "r" -> setValue(-0.00005)
        "e" -> setValue(-0.00001)
        "w" -> setValue(-0.000005)
        "q" -> setValue(-0.000001)
        "p" -> setValue(+0.000001)
        "o" -> setValue(+0.000005)
        "i" -> setValue(+0.00001)
        "u" -> setValue(+0.00005)
        "y" -> setValue(+0.0001)
        "h" -> setValue(+0.0005)
        "j" -> setValue(+0.001)
        "k" -> setValue(+0.01)
        "l" -> setValue(+1.0)
        ";" -> setValue(+10.0)
    }
}

fun KeyEvent.mapZxcvKeyRow(setValue: (Double) -> Unit) {
    when (name) {
        "z" -> setValue(-5.0)
        "x" -> setValue(-0.001)
        "c" -> setValue(-0.0001)
        "v" -> setValue(-0.00005)
        "b" -> setValue(-0.00001)
        "n" -> setValue(+0.00001)
        "m" -> setValue(+0.00005)
        "," -> setValue(+0.0001)
        "." -> setValue(+0.001)
        "/" -> setValue(+5.0)
    }
}

fun Program.onNumberKeys(setSeedFunction: (Int) -> Unit) {
    keyboard.keyDown.listen {
        if (it.modifiers.isEmpty() && it.name in "123456789") setSeedFunction(it.name.toInt() - 1)
    }
}

fun Program.onCmdNumberKeys(function: (Int) -> Unit) {
    keyboard.keyDown.listen {
        if (it.modifiers.contains(KeyModifier.SUPER) && it.name in "123456789") function(it.name.toInt() - 1)
    }
}

fun Program.onFKeys(onFKey: (Int) -> Unit) {
    val fKeys = listOf("f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12")
    keyboard.keyDown.listen {
        if (it.name in fKeys) {
            onFKey(it.name.drop(1).toInt() - 1)
        }
    }
}

fun Program.executeOnKey(keyName: String, function: () -> Unit) {
    keyboard.keyUp.listen {
        if (it.name == keyName) {
            function()
        }
    }
}

fun Program.onKeyEvent(setValue: (KeyEvent) -> Unit) {
    keyboard.keyRepeat.listen(setValue)
    keyboard.keyDown.listen(setValue)
}

fun Body.addCurvesButton() {
    button {
        fun getCurvesButtonLabel() = if (curvesEnabled) "Curves ON" else "Curves OFF"
        label = getCurvesButtonLabel()
        events.clicked.listen {
            curvesEnabled = !curvesEnabled
            label = getCurvesButtonLabel()
        }
    }
}

fun Body.addFillButton() {
    button {
        fun getFillButtonLabel() = if (fillEnabled) "Fill ON" else "Fill OFF"
        label = getFillButtonLabel()
        events.clicked.listen {
            fillEnabled = !fillEnabled
            label = getFillButtonLabel()
        }
    }
}
