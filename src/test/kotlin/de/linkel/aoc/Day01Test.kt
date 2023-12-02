package de.linkel.aoc

class Day01Test: AbstractDayTest<Int>() {
    override val exampleA = """
199
200
208
210
200
207
240
269
260
263
        """.trimIndent()
    override val exampleSolutionA = 7
    override val solutionA = 1624

    override val exampleSolutionB = 5
    override val solutionB = 1653

    override val implementation = Day01()
}
