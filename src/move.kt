package com.aarocket.pokemonkt

import java.io.File

data class Move(
    val ID: Int,
    val name: String,
    val power: Int,
    val accuracy: Int,
    val pp: Int,
    val category: Int,
    val contact: Boolean,
    val type: Int,
    val priority: Int,
    val range: Int,
    val description: String,
    val notes: String,
)

fun mover(movelist_path : String) : List<Move> {
    val movepath = movelist_path
    val file = File(movepath)

    if (!file.exists()) {
        println("Error: The file '$movepath' was not found.")
        null
    }
    val moves: List<Move> = file.readLines().mapNotNull { line ->
        val columns = line.split('|')

        if (columns.size == 12) {
            try {
                Move(
                    ID = columns[0].toInt(),
                    name = columns[1].trim(),
                    power = columns[2].toInt(),
                    accuracy = columns[3].toInt(),
                    pp = columns[4].toInt(),
                    category = columns[5].toInt(),
                    contact = columns[6].toInt().toBoolean(),
                    type = columns[7].toInt(),
                    priority = columns[8].toInt(),
                    range = columns[9].toInt(),
                    description = columns[10].trim().replace("[NEWLINE]","\n"),
                    notes = columns[11].trim()
                )
            } catch (e: NumberFormatException) {
                null // Return null for this line if a number format is incorrect.
            }
        } else {
            null // Return null for this line if the column count is wrong.
        }
    }
    return moves
}

val moveslist = mover("moves_2.dat")
val n_moves = moveslist.size
