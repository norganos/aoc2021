package de.linkel.aoc

import de.linkel.aoc.base.AbstractLinesAdventDay
import de.linkel.aoc.base.QuizPart
import de.linkel.aoc.utils.grid.Point
import de.linkel.aoc.utils.grid.Vector
import de.linkel.aoc.utils.space.discrete.Point3d
import de.linkel.aoc.utils.space.discrete.Vector3d
import jakarta.inject.Singleton
import java.lang.Exception

@Singleton
class Day02: AbstractLinesAdventDay<Int>() {
    override val day = 2

    override fun process(part: QuizPart, lines: Sequence<String>): Int {
        return if (part == QuizPart.A) processA(lines)
        else processB(lines)
    }

    fun processA(lines: Sequence<String>): Int {
        val point = lines.fold(Point(0,0)) { pos, line ->
            val tokens = line.split(' ')
            val command = tokens[0]
            val param = tokens[1].toInt()
            when(command) {
                "forward" -> pos + Vector(param, 0)
                "down" -> pos + Vector(0, param)
                "up" -> pos + Vector(0, -param)
                else -> throw Exception("invalid command $command  $param")
            }
        }
        return point.x * point.y
    }

    fun processB(lines: Sequence<String>): Int {
        val point = lines.fold(Point3d(0,0, 0)) { pos, line ->
            val tokens = line.split(' ')
            val command = tokens[0]
            val param = tokens[1].toInt()
            when(command) {
                "forward" -> pos + Vector3d(param, pos.z * param, 0)
                "down" -> pos + Vector3d(0, 0, param)
                "up" -> pos + Vector3d(0, 0, -param)
                else -> throw Exception("invalid command $command  $param")
            }
        }
        return point.x * point.y
    }
}
