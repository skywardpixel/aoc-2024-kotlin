import kotlin.math.abs

fun main() {
    fun isSafe(levels: List<Int>): Boolean {
        if (levels.count() < 2) {
            return true
        }
        val firstDiff = levels[1] - levels[0]
        if (abs(firstDiff) < 1 || abs(firstDiff) > 3) {
            return false
        }
        for (i in 2 until levels.count()) {
            val diff = levels[i] - levels[i - 1]
            if (abs(diff) < 1 || abs(diff) > 3 || diff * firstDiff <= 0) {
                return false
            }
        }
        return true
    }

    fun part1(input: List<String>): Int {
        return input.count { line -> isSafe(line.split(" ").map { it.toInt()}) }
    }

    fun part2(input: List<String>): Int {
        return input.count { line ->
            val levels = line.split(" ").map { it.toInt() }
            (0 until levels.count()).any {
                val removed = levels.filterIndexed { index, i -> index != it }
                isSafe(removed)
            }
        }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
