package com.aarocket.pokemonkt

import java.io.File
import java.io.BufferedReader

fun pd2() {
    val bufferedReader: BufferedReader = File("/home/antoine/projects/pokemonpy-package/src/pokemonpy/somemons/somemons.dat").bufferedReader()    
    val inputString = bufferedReader.use { it.readLine() }
    println(inputString)
}

// Data class to represent a single record from the CSV file.
// Each property corresponds to a column in the CSV.

fun pokedexer(pokedex_path : String) : List<Dexpage> {
    val dexpath = pokedex_path
    val file = File(dexpath)

    // Check if the file exists before attempting to read it.
    if (!file.exists()) {
        println("Error: The file '$dexpath' was not found.")
        null
    }

    // Read all lines from the file, skipping the header row with drop(1).
    val dex: List<Dexpage> = file.readLines().mapNotNull { line ->
        // Split each line by the comma delimiter.
        val columns = line.split(',')

        // Basic validation to ensure the row has the correct number of columns.
        if (columns.size == 10) {
            try {
                // Create a Dexpage object by converting each column to the correct type.
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
                //println("Warning: Skipping malformed line (invalid number): $line")
                null // Return null for this line if a number format is incorrect.
            }
        } else {
            // println("Warning: Skipping malformed line (incorrect column count): $line")
            null // Return null for this line if the column count is wrong.
        }
    }
    return dex
}

val pokedex = pokedexer("somemons.dat")