package com.aarocket.pokemonkt

//import kotlin.random.Random

class mon (var name: String, var level: Int = 100, var nature1: Int = 0, var nature2: Int = 0,
           var hpbase: Int = 100, var atbase: Int = 100, var debase: Int = 100,
           var sabase: Int = 100, var sdbase: Int = 100, var spbase: Int = 100,
           var type1: Int = 0, val type2: Int = 18, val random_move: Boolean = true, var how_created: String = "nursery") {
    init {
        //birth details
        // record the time of initialization
        // record location, using timezone
        // record the exact method of intialization
        // has it entered the hall of fame?
        var gender = listOf("N","F","M").random()
    }

    fun print_me() {
        println("Name: $name")
        println("Level: $level")
        println("Base Attack Stat: $atbase")
    }
}

//fun main() {
//	val mon1 = mon("Dolly")
//	mon1.print_me()
//}
