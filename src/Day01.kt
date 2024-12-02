import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input
            .map { line ->
                val left = line.substringBefore(" ")
                val right = line.substringAfterLast(" ")
                left.toInt() to right.toInt()
            }
            .unzip()
        return left.sorted().zip(right.sorted())
            .sumOf { (left, right) -> (left - right).absoluteValue }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = input
            .map { line ->
                val left = line.substringBefore(" ")
                val right = line.substringAfterLast(" ")
                left.toInt() to right.toInt()
            }
            .unzip()
        val rightCounts = right.groupingBy { it }.eachCount()
        return left.sumOf { it * (rightCounts[it] ?: 0) }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
