package de.linkel.aoc

import de.linkel.aoc.base.AbstractLinesAdventDay
import de.linkel.aoc.base.QuizPart
import jakarta.inject.Singleton

@Singleton
class Day03: AbstractLinesAdventDay<Int>() {
    override val day = 3

    override fun process(part: QuizPart, lines: Sequence<String>): Int {
        return if (part == QuizPart.A) processA(lines)
        else processB(lines)
    }
    fun processA(lines: Sequence<String>): Int {
        val bits = lines.fold(emptyList<BitCounter>()) { counters, line ->
            if (counters.isEmpty())
                line.toCharArray().map { BitCounter() + it }
            else {
                val chars = line.toCharArray()
                counters
                    .mapIndexed { idx, counter ->
                        counter + chars[idx]
                    }
            }
        }
            .reversed()
        val gamma = bits.foldIndexed(0) { idx, sum, counter ->
            if (counter.one < counter.zero) sum
            else sum + (1 shl idx)
        }
        val epsilon = bits.foldIndexed(0) { idx, sum, counter ->
            if (counter.one > counter.zero) sum
            else sum + (1 shl idx)
        }
        return gamma * epsilon
    }

    fun filter(input: List<String>, idx: Int, criteria: (counter: BitCounter) -> Char): List<String> {
        return if (input.size == 1) input
        else {
            val bits = input.fold(BitCounter()) { counter, line ->
                counter + line.toCharArray()[idx]
            }
            val filterChar = criteria(bits)
            return filter(input.filter { it.toCharArray()[idx] == filterChar }, idx + 1, criteria)
        }
    }

    fun processB(lines: Sequence<String>): Int {
        val copy = lines.toList()
        val oxygen = filter(copy, 0) { if (it.zero > it.one) '0' else '1' }
            .first().toCharArray().reversed().foldIndexed(0) { idx, sum, c ->
                if (c == '0') sum
                else sum + (1 shl idx)
            }
        val co2 = filter(copy, 0) { if (it.one < it.zero) '1' else '0' }
            .first().toCharArray().reversed().foldIndexed(0) { idx, sum, c ->
                if (c == '0') sum
                else sum + (1 shl idx)
            }
        return oxygen * co2
    }

    data class BitCounter(
        val zero: Int = 0,
        val one: Int = 0
    ) {
        operator fun plus(c: Char): BitCounter {
            return when (c) {
                '1' -> copy(one = one + 1)
                '0' -> copy(zero = zero + 1)
                else -> throw Exception("expected only 1 and 0")
            }
        }
    }
}
