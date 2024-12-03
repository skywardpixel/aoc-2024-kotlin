fun main() {
    fun part1(input: List<String>): Int {
        val data = input.joinToString("")
        val mulPattern = Regex("""mul\((\d+),(\d+)\)""")
        var sum = 0
        for (match in mulPattern.findAll(data)) {
            val num1 = match.groupValues[1].toInt()
            val num2 = match.groupValues[2].toInt()
            sum += num1 * num2
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val data = input.joinToString("")
        val mulPattern = Regex("""mul\((\d+),(\d+)\)|do\(\)|don't\(\)""")
        var sum = 0
        var enabled = true
        for (match in mulPattern.findAll(data)) {
            if (match.groupValues[0] == "don't()") {
                enabled = false
            } else if (match.groupValues[0] == "do()") {
                enabled = true
            } else {
                if (enabled) {
                    val num1 = match.groupValues[1].toInt()
                    val num2 = match.groupValues[2].toInt()
                    sum += num1 * num2
                }
            }
        }
        return sum
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
