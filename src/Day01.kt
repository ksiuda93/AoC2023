fun part1(input: List<String>): Int {
    return input.sumOf { line: String ->
        line.first { it.isDigit() }.digitToInt() * 10 + line.last { it.isDigit() }.digitToInt()
    }
}

fun part2(input: List<String>): Int {
    val words: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    var sum: Int = 0
    input.forEach { line: String ->
        sum += sumOfFirstAndLastDigit(clearLine(line, words))
    }
    return sum
}

fun clearLine(line: String, words: Map<String, Int>): String {
    var newLine: String = line
    words.forEach { (word, number) ->
        if (newLine.contains(word)) {
            newLine = newLine.replace(word, "${word.first()}${number.toString()}${word.last()}")
        }
    }
    return newLine
}

fun sumOfFirstAndLastDigit(line: String): Int {
    return line.first { it.isDigit() }.digitToInt() * 10 + line.last { it.isDigit() }.digitToInt()
}


fun main() {
    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}