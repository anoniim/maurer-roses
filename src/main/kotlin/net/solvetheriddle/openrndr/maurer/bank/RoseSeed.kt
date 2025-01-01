package net.solvetheriddle.openrndr.maurer.bank

data class RoseSeed(
    val nValue: Double,
    val dValue: Double,
) {
    fun isNotEmpty() = this != Empty

    companion object {
        fun fromString(input: String): RoseSeed {
            val (nValue, dValue) = input.split(",")
            return RoseSeed(nValue.toDouble(), dValue = dValue.toDouble())
        }

        val Empty = RoseSeed(0.0, 0.0)
    }
}