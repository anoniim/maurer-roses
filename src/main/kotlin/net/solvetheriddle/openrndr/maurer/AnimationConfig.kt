package net.solvetheriddle.openrndr.maurer

import org.openrndr.animatable.easing.Easing

open class AnimationConfig(
    val serial: Int,
    val n1: Double,
    val n2: Double,
    val n3: Double,
    val animationDuration: Long,
    val animationEasing: Easing
) {

    object A1 : AnimationConfig(
        serial = 1,
        n1 = .5,
        n2 = 1.0,
        n3 = 2.0,
        animationDuration = 10_000L,
        animationEasing = Easing.SineInOut,
    )

    object A2 : AnimationConfig(
        // Miso
        serial = 2,
        n1 = 2.0,
        n2 = 3.0,
        n3 = 4.0,
        animationDuration = 10_000L,
        animationEasing = Easing.SineInOut,
    )

    object A3 : AnimationConfig(
        // Filip
        serial = 3,
        n1 = 4.0,
        n2 = 5.0,
        n3 = 6.0,
        animationDuration = 10_000L,
        animationEasing = Easing.SineInOut,
    )

    object A4 : AnimationConfig(
        // Miruna
        serial = 4,
        n1 = 6.0,
        n2 = 7.005,
        n3 = 9.0,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )

    object A5 : AnimationConfig(
        // Terka
        serial = 5,
        n1 = 9.0,
        n2 = 11.0,
        n3 = 13.0,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )

    object A6 : AnimationConfig(
        // Otis (stage)
        serial = 6,
        n1 = 13.0,
        n2 = 14.0111,
        n3 = 15.0144,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )

    object A7 : AnimationConfig(
        // Isa (butterfly)
        serial = 7,
        n1 = 15.0144,
        n2 = 17.0186,
        n3 = 19.0226,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )

    object Something1 : AnimationConfig(
        serial = 100,
        n1 = 142.821594,
        n2 = 142.826144,
        n3 = 142.828444,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )

    object Something2 : AnimationConfig(
        serial = 101,
        n1 = 201.132662,
        n2 = 142.826144,
        n3 = 142.828444,
        animationDuration = 20_000L,
        animationEasing = Easing.CubicInOut,
    )
}
