package com.aarocket.pokemonkt

//import kotlin.random.Random

class mon (
    var name: String,
    var level: Int = 100,
    var hpb: Int = 100,
    var atb: Int = 100,
    var deb: Int = 100,
    var sab: Int = 100,
    var sdb: Int = 100,
    var spb: Int = 100,
    var hpiv: Int = (0..31).toList().random(),
    var ativ: Int = (0..31).toList().random(),
    var deiv: Int = (0..31).toList().random(),
    var saiv: Int = (0..31).toList().random(),
    var sdiv: Int = (0..31).toList().random(),
    var spiv: Int = (0..31).toList().random(),
    var hpev: Int = 0,
    var atev: Int = 0,
    var deev: Int = 0,
    var saev: Int = 0,
    var sdev: Int = 0,
    var spev: Int = 0,
    var attack: Int = 1,
    var defense: Int = 1,
    var spatk: Int = 1,
    var spdef: Int = 1,
    var speed: Int = 1,
    var maxhp: Int = 100,
    var currenthp: Int = 100,
    var currenthpp: Double = 100.0,
    val type1: Int = 0, val type2: Int = 99,
    var type: Array<Int> = arrayOf<Int>(0),
    var dualType: Boolean = false,
    var gender: String = "not set",
    var nature1: Int = 0, var nature2: Int = 0,
    var null_nature: Boolean = true,
    var nature_multipliers: Array<Double> = arrayOf<Double>(1.0,1.0,1.0,1.0,1.0),
    var knownMoves: List<Int> = mutableListOf(0),
    val random_move: Boolean = true,
    var how_created: String = "nursery"
    ) {
    init {
        //birth details
        // record the time of initialization
        // record location, using timezone
        // record the exact method of intialization
        // has it entered the hall of fame?
        //
        // GENDER
        // if gender has not been assigned, assign a gender
        // at random
        if (gender == "not set") {
            gender = listOf("N","F","M").random()
        }

        // calculate the nature multiplier array
        
        if (nature1 == nature2) {
            null_nature = true
        } else {
            null_nature = false
            nature_multipliers[nature1] = 1.1
            nature_multipliers[nature2] = 0.9
        }
        // calculate the stats
        attack = stat_calculation(level, atb, ativ, atev, nature_multipliers[0])
        defense = stat_calculation(level, deb, deiv, deev, nature_multipliers[1])
        spatk = stat_calculation(level, sab, saiv, saev, nature_multipliers[2])
        spdef = stat_calculation(level, sdb, sdiv, sdev, nature_multipliers[3])
        speed = stat_calculation(level, spb, spiv, spev, nature_multipliers[4])
        maxhp = HPstat_calculation(level, hpb, hpiv, hpev)
        currenthp = maxhp
        currenthpp = 100.0
        // TYPE ASSIGNMENT
        // is type1 is an invalid type?
        if ((type1 > 18) || (type1 < 0)) { //yes
            //dualType = false
            // is type 2 an invalid type?
            if ((type2 > 18) || (type2 < 0)) {
                //yes
                //no valid types, assign the normal type
                type = arrayOf<Int>(0)
            } else {//no
                //assign type1 to be type2's type, singly typed pokemon
                type = arrayOf<Int>(type2)
            }
        } else { //no, type1 is valid
            //is there a valid type 2?
            if ((type2 < 19) && (type2 >= 0)) {
                //yes
                //is type 2 the same as type 1?
                if (type2 == type1) {
                    //yes
                    //pokemon is singly typed
                    //dualType = false
                    type = arrayOf<Int>(type1)
                } else {//no
                    //pokemon has 2 types, assigned normally
                    //dualType = true
                    type = arrayOf<Int>(type1,type2)
                }
            } else {//no
                //pokemon is singly typed
                //dualType = false
                type = arrayOf<Int>(type1)
            }
        }
        // is it a dualtype?
        if (type.size >= 2) dualType = true else dualType = false
        //
    }

    fun summary() {
        val type1str = typeStrings[type[0]]
        println("Name: $name\t| Level: $level")
        if (dualType) {
            val type2str = typeStrings[type[1]]
            println("Type: $type1str | $type2str")
        } else {
            println("Type: $type1str")
        }
    }

    fun print_me() {
        println("Name: $name")
        println("Level: $level")
    }
}

//fun main() {
//	val mon1 = mon("Dolly")
//	mon1.print_me()
//}
