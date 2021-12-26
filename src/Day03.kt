fun main() {
    println(part2(readInput("Day02_02")))
}

fun part1(input: List<String>): Any {
    var (gamma, epsilon) = listOf("", "")
    input.first().toCharArray().forEachIndexed { index, c ->
        println(index)
        gamma += if (getMostCommonBit(input, index) == '1') '0' else '1'
        epsilon += getMostCommonBit(input, index)
    }
    return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
}

fun part2(input: List<String>): Any {
    var clonedList = input.toMutableList()
    run oxygen@{
        input.first().toCharArray().forEachIndexed { index, c ->
            val mostCommon = getMostCommonBit(input, index)

            clonedList.toMutableList().forEach {
                if (it[index] != mostCommon) {
                    clonedList.remove(it)
                }
            }
            if (clonedList.size == 1) return@oxygen
        }
    }
    val oxygen = clonedList.first()
    clonedList = input.toMutableList()

    run scrubber@{
        input.first().toCharArray().forEachIndexed { index, c ->
            val mostCommon = getMostCommonBit(input, index)
            clonedList.toMutableList().forEach {
                if (it[index] != if (mostCommon == '1') '0' else '1') {
                    clonedList.remove(it)
                }
            }
            if (clonedList.size == 1) return@scrubber
        }
    }
    val scrubber = clonedList.first()
    return Integer.parseInt(oxygen,2) * Integer.parseInt(scrubber, 2)
}

private fun getMostCommonBit(input: List<String>, index: Int): Char {
    var count = 0
    input.forEach { count += if (it.toCharArray()[index] == '1') 1 else -1 }
    return if (count >= 0) '1' else '0'
}
