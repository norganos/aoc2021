package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day02Test {
    val example = """
forward 5
down 5
forward 8
up 3
down 8
forward 2
        """.trimIndent()

    @Test
    fun `example part 1`() {
        Assertions.assertThat(Day02().test(QuizPart.A, example)).isEqualTo(150)
    }

    @Test
    fun `example part 2`() {
        Assertions.assertThat(Day02().test(QuizPart.B, example)).isEqualTo(900)
    }

    @Test
    fun `solution part 1`() {
        Assertions.assertThat(Day02().solve(QuizPart.A)).isEqualTo(1936494)
    }

    @Test
    fun `solution part 2`() {
        Assertions.assertThat(Day02().solve(QuizPart.B)).isEqualTo(1997106066)
    }
}
