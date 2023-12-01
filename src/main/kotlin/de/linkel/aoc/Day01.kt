package de.linkel.aoc

import de.linkel.aoc.base.AbstractLinesAdventDay
import de.linkel.aoc.base.QuizPart
import jakarta.inject.Singleton
import java.lang.Exception
import kotlin.math.min

@Singleton
class Day01: AbstractLinesAdventDay<Int>() {
    override val day = 1
    override val parts = QuizPart.BOTH

    override fun process(part: QuizPart, lines: Sequence<String>): Int {
        return if (part == QuizPart.A)
            lines
                .map { it.toInt() }
                .fold(IncrCounter(Integer.MIN_VALUE, -1)) { agg, v ->
                    agg.copy(
                        lastValue = v,
                        incrCount = if (v > agg.lastValue) agg.incrCount + 1 else agg.incrCount
                    )
                }
                .incrCount
        else
            lines
                .map { it.toInt() }
                .windowed(3)
                .fold(IncrCounter(Integer.MIN_VALUE, -1)) { agg, v ->
                    agg.copy(
                        lastValue = v.sum(),
                        incrCount = if (v.sum() > agg.lastValue) agg.incrCount + 1 else agg.incrCount
                    )
                }
                .incrCount
    }

    data class IncrCounter(
        val lastValue: Int,
        val incrCount: Int = 0,
    )
}
