package de.linkel.aoc

import de.linkel.aoc.base.QuizPart
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day01Test {
    val example = """
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

    @Test
    fun `example part 1`() {
        Assertions.assertThat(Day01().test(QuizPart.A, example)).isEqualTo(7)
    }

    @Test
    fun `example part 2`() {
        Assertions.assertThat(Day01().test(QuizPart.B, example)).isEqualTo(5)
    }

    @Test
    fun `solution part 1`() {
        Assertions.assertThat(Day01().solve(QuizPart.A)).isEqualTo(1624)
    }

    @Test
    fun `solution part 2`() {
        Assertions.assertThat(Day01().solve(QuizPart.B)).isEqualTo(1653)
    }
}
