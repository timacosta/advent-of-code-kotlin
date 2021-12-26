package day_01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.windowed(
            size = 2,
            transform = {
                it[0] < it[1]
            }
        ).count { it }
    }

    fun part2(input: List<String>): Int {
        var intList = mutableListOf(input.size)
        input.mapIndexed { index, s ->
            intList[index] = s.toInt()
        }

        return intList.windowed(
            size = 3,
            transform = {
                it.sum()
            }
        ).windowed(
            size = 2,
            transform = {
                it[0] < it[1]
            }
        ).count { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_01_test")
    check(part1(testInput) == 1445)

    val input1 = readInput("Day01_01_test")
    val input2 = readInput("Day01_02_test")

    //println(part1(input1))
    println(part2(input2))
}
