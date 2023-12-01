package de.linkel.aoc

import de.linkel.aoc.base.AbstractLinesAdventDay
import de.linkel.aoc.base.QuizPart
import de.linkel.aoc.utils.grid.Point
import jakarta.inject.Singleton

@Singleton
class Day04: AbstractLinesAdventDay<Int>() {
    override val day = 4
    override val parts = QuizPart.BOTH

    override fun process(part: QuizPart, lines: Sequence<String>): Int {
        val allLines = lines.toList() // I hate myself for this :-/
        val draws = allLines.first().split(",").map { it.toInt() }
        val boards = allLines.drop(1).chunked(6)
            .map { board ->
                assert(board.first().isEmpty())
                Board(
                    board.drop(1)
                        .flatMapIndexed { y, row ->
                            row.split(" ")
                                .filter { it.isNotEmpty() }
                                .mapIndexed { x, cell ->
                                    Cell(point = Point(x, y), number = cell.toInt(), marked = false)
                                }
                        }
                        .associateBy { it.point }
                )
            }
        return if (part == QuizPart.A) {
            playA(boards, draws)
        } else {
            playB(boards, draws, 0)
        }
    }

    private fun playA(boards: List<Board>, draws: List<Int>): Int {
        val draw = draws.first()
        val newBoards = boards
            .map { it + draw }
        val winner = newBoards.firstOrNull { it.getWinningStreak() != null }
        return if (winner != null) {
            winner.getUnmarkedSum() * draw
        } else playA(newBoards, draws.drop(1))
    }
    private fun playB(boards: List<Board>, draws: List<Int>, lastWin: Int): Int {
        if (boards.isEmpty() || draws.isEmpty()) return lastWin
        val draw = draws.first()
        val newBoards = boards
            .map { it + draw }
        val partition = newBoards.partition { it.getWinningStreak() != null }
        return playB(partition.second, draws.drop(1), partition.first.firstOrNull()?.getUnmarkedSum()?.let { it * draw } ?: lastWin)
    }

    data class Board(
        val cells: Map<Point, Cell>
    ) {
        operator fun plus(number: Int): Board {
            return copy(
                cells = cells + cells.entries.filter { it.value.number == number }.associate { it.key to it.value.copy(marked = true) }
            )
        }
        fun getWinningStreak(): List<Cell>? {
            val marked = cells.entries.filter { it.value.marked }.map { it.value }
            return marked
                .map { it.point.x }
                .distinct()
                .firstNotNullOfOrNull { x ->
                    val col = (0..<5).map { y -> cells[Point(x, y)]!! }
                    if (col.all { it.marked }) col else null
                } ?: marked
                .map { it.point.y }
                .distinct()
                .firstNotNullOfOrNull { y ->
                    val row = (0..<5).map { x -> cells[Point(x, y)]!! }
                    if (row.all { it.marked }) row else null
                }
        }

        fun getUnmarkedSum(): Int {
            return cells.entries
                .filter { !it.value.marked }
                .sumOf { it.value.number }
        }
    }
    data class Cell(
        val point: Point,
        val number: Int,
        val marked: Boolean
    )
}
