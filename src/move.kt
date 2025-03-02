package com.aarocket.pokemonkt

data class move(
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