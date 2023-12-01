package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day05Test {
    val example = """
        """.trimIndent()

    @Test
    fun `example part 1`() {
        Assertions.assertThat(Day05().test(QuizPart.A, example)).isEqualTo(0)
    }

    @Test
    fun `example part 2`() {
        Assertions.assertThat(Day05().test(QuizPart.B, example)).isEqualTo(0)
    }

    @Test
    fun `solution part 1`() {
        Assertions.assertThat(Day05().solve(QuizPart.A)).isEqualTo(0)
    }

    @Test
    fun `solution part 2`() {
        Assertions.assertThat(Day05().solve(QuizPart.B)).isEqualTo(0)
    }
}
