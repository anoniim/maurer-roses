package net.solvetheriddle.openrndr.maurer.ui

import org.openrndr.KeyEvent
import org.openrndr.KeyModifier
import org.openrndr.Program

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