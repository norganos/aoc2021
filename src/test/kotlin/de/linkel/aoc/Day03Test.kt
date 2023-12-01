package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day03Test {
    val example = """
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

    @Test
    fun `example part 1`() {
        Assertions.assertThat(Day03().test(QuizPart.A, example)).isEqualTo(198)
    }

    @Test
    fun `example part 2`() {
        Assertions.assertThat(Day03().test(QuizPart.B, example)).isEqualTo(230)
    }

    @Test
    fun `solution part 1`() {
        Assertions.assertThat(Day03().solve(QuizPart.A)).isEqualTo(4160394)
    }

    @Test
    fun `solution part 2`() {
        Assertions.assertThat(Day03().solve(QuizPart.B)).isEqualTo(4125600)
    }
}
