package day_02

import readInput

fun main() {
    fun part1(input: List<String>): Any {
        var (gamma, epsilon) = listOf("", "")
        input.first().toCharArray().forEachIndexed { index, c ->
            println(index)
            gamma += if (getMostCommonBit(input, index) == '1') '0' else '1'
            epsilon += getMostCommonBit(input, index)
        }
        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_01_test")
    val input1 = readInput("Day02_01")
    check(part1(testInput) == 1071734)
}

private fun getMostCommonBit(input: List<String>, index: Int): Char {
    var count = 0
    input.forEach { count += if (it.toCharArray()[index] == '1') 1 else -1 }
    return if (count >= 0) '1' else '0'
}
