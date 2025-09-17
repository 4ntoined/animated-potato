package com.aarocket.pokemonkt

import java.io.File
//import java.io.BufferedReader

data class Dexpage(
    val ID: Int,
    val species: String,
    val hp: Int,
    val at: Int,
    val de: Int,
    val sa: Int,
    val sd: Int,
    val sp: Int,
    val type1: Int,
    val type2: Int
)

fun pokedexer(pokedex_path : String) : List<Dexpage> {
    val dexpath = pokedex_path
    val file = File(dexpath)

    if (!file.exists()) {
        println("Error: The file '$dexpath' was not found.")
        null
    }
    val dex: List<Dexpage> = file.readLines().mapNotNull { line ->
        val columns = line.split(',')

        if (columns.size == 10) {
            try {
                Dexpage(
                    ID = columns[0].toInt(),
                    species = columns[1].trim(),
                    hp = columns[2].toInt(),
                    at = columns[3].toInt(),
                    de = columns[4].toInt(),
                    sa = columns[5].toInt(),
                    sd = columns[6].toInt(),
                    sp = columns[7].toInt(),
                    type1 = columns[8].toInt(),
                    type2 = columns[9].toInt()
                )
            } catch (e: NumberFormatException) {
                null // Return null for this line if a number format is incorrect.
            }
        } else {
            null // Return null for this line if the column count is wrong.
        }
    }
    return dex
}

val pokedex = pokedexer("somemons.dat")