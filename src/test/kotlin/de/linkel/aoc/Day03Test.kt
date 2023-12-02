package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day03Test: AbstractDayTest<Int>() {
    override val exampleA = """
00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010
        """.trimIndent()
    override val exampleSolutionA = 198
    override val solutionA = 4160394

    override val exampleSolutionB = 230
    override val solutionB = 4125600

    override val implementation = Day03()
}
