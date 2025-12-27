package net.solvetheriddle.openrndr.maurer.bank

data class RoseSeed(
    val nValue: Double,
    val dValue: Double,
) {
    fun isNotEmpty() = this != Empty

    companion object {
        fun fromString(input: String): RoseSeed {
            println(input)
            return if (input.contains(",")) {
                val (nValue, dValue) = input.split(",")
                val nValueSanitized = removePrefixBefore(nValue, ':')
                RoseSeed(nValueSanitized.toDouble(), dValue = dValue.toDouble())
            } else Empty
        }

        @Suppress("SameParameterValue")
        private fun removePrefixBefore(input: String, char: Char): String {
            return if (input.contains(char)) {
                input.removeRange(0..input.indexOfFirst { it == char })
            } else input
        }

        val Empty = RoseSeed(0.0, 0.0)
    }
}