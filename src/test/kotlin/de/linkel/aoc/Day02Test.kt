package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test: AbstractDayTest<Int>() {
    override val exampleA = """
forward 5
down 5
forward 8
up 3
down 8
forward 2
        """.trimIndent()
    override val exampleSolutionA = 150
    override val solutionA = 1936494

    override val exampleSolutionB = 900
    override val solutionB = 1997106066

    override val implementation = Day02()
}
