package com.aarocket.pokemonkt

//import kotlin.random.Random
import java.util.TimeZone
//import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.ZoneId
//import java.time.ZoneOffset
import java.time.Instant
//import java.time.format.DateTimeFormatter

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
    var battack: Int = 1,
    var bdefense: Int = 1,
    var bspatk: Int = 1,
    var bspdef: Int = 1,
    var bspeed: Int = 1,
    var type1: Int = 0,
    var type2: Int = 99,
    var type: Array<Int> = arrayOf<Int>(0),
    var dualType: Boolean = false,
    var gender: String = "not set",
    var nature_up: Int = 0,
    var nature_down: Int = 0,
    var null_nature: Boolean = true,
    var nature_multipliers: Array<Double> = arrayOf<Double>(1.0,1.0,1.0,1.0,1.0),
    var knownMoves: List<Int> = mutableListOf(0),
    val random_move: Boolean = true,
    var birth_path: String = "hacked",
    var birth_place: String = "not set",
    val birth_time_seconds: Long = -999999,
    val birth_time_nanos: Int = -999999,
    var birth_time_instant: Instant = Instant.ofEpochSecond(0),
    var halloffame_count: Int = 0,
    ) {
    init {
        // BIRTH details
        // record the method of intialization
        if (birth_place == "not set") {
            // birth place data not given, use system setting
            // otherwise, go with whatever was given in the constructor, even if that's nonsense
            birth_place = TimeZone.getDefault().id
        }
        // record the time and place of initialization
        // birth time data NOT given, use current time
        if ((birth_time_seconds == -999999.toLong()) && (birth_time_nanos == -999999)){
            birth_time_instant = Instant.now()
        } else { //birth time data WAS given, use it to construct the birth time variable
            birth_time_instant = Instant.ofEpochSecond(birth_time_seconds,birth_time_nanos.toLong())
        }
        //val birth_time_local = LocalDateTime.now()
        //var birth_time_UTC = ZonedDateTime.now(ZoneOffset.UTC)
        //var birth_time_local = birth_time_UTC.withZoneSameInstant(ZoneId.of(birth_place))
        //
        // GENDER
        // if gender has not been assigned, assign a gender at random
        if (gender == "not set") {
            gender = listOf("N","F","M").random()
        }
        // NATURE
        // calculate the nature multiplier array
        if (nature_up != nature_down) {
            null_nature = false
            nature_multipliers[nature_up] = 1.1
            nature_multipliers[nature_down] = 0.9
        } else {
            null_nature = true
        }
        // STATS
        attack = stat_calculation(level, atb, ativ, atev, nature_multipliers[0])
        defense = stat_calculation(level, deb, deiv, deev, nature_multipliers[1])
        spatk = stat_calculation(level, sab, saiv, saev, nature_multipliers[2])
        spdef = stat_calculation(level, sdb, sdiv, sdev, nature_multipliers[3])
        speed = stat_calculation(level, spb, spiv, spev, nature_multipliers[4])
        maxhp = HPstat_calculation(level, hpb, hpiv, hpev)
        currenthp = maxhp
        currenthpp = 100.0
        // IN-BATTLE STATS
        battack = attack
        bdefense = defense
        bspatk = spatk
        bspdef = spdef
        bspeed = speed
        // TYPE ASSIGNMENT
        // is type1 is an invalid type?
        if ((type1 > 17) || (type1 < 0)) { //yes
            // is type 2 an invalid type?
            if ((type2 > 17) || (type2 < 0)) {
                //yes
                // no valid types, assign the normal type
                type = arrayOf<Int>(18)
            } else {// type 2 is valid, type 1 is not
                // assign type1 to be type2's type, singly typed pokemon
                type = arrayOf<Int>(type2)
            }
        } else { // type 1 is valid
            // is there a valid type 2?
            if ((type2 < 18) && (type2 >= 0)) {
                // type 2 and type 1 are valid
                // is type 2 the same as type 1?
                if (type2 == type1) {
                    // the two types are the same
                    // the pokemon is singly typed
                    type = arrayOf<Int>(type1)
                } else {// type 2 is different from type 1
                    //pokemon has 2 types, assigned normally
                    type = arrayOf<Int>(type1,type2)
                }
            } else {// type 2 is not valid, type 1 is
                // pokemon is singly typed
                type = arrayOf<Int>(type1)
            }
        }
        // is it a dualtype?
        if (type.size >= 2) dualType = true else dualType = false
        //
    }

    fun summary(inBattle: Boolean = false) {
        // NAME
        println("Name:   \t$name")
        // LEVEL
        println("Level:  \t$level")
        // TYPE
        val type1str = typeStrings[type[0]]
        if (dualType) {
            val type2str = typeStrings[type[1]]
            println("Type:   \t$type1str // $type2str")
        } else {
            println("Type:   \t$type1str")
        }
        // GENDER
        println("Gender: \t$gender")
        // NATURE
        val naturestr = nature_names[nature_up][nature_down]
        val naturestat_up = nature_stat_str[nature_up]
        val naturestat_down = nature_stat_str[nature_down]
        
        println("Nature: $naturestr | Boosted - $naturestat_up, Nerfed - $naturestat_down")
        // STATS
        println("HP     :\t$currenthp/$maxhp \t$currenthpp%")
        if (inBattle) {
            //
            println("*These stats reflect in-battle boosts and nerfs.*")
            println("Attack :\t$battack")
            println("Defense:\t$bdefense")
            println("Sp.Atk :\t$bspatk")
            println("Sp.Def :\t$bspdef")
            println("Speed  :\t$bspeed")
            
        } else {
            //
            println("Attack :\t$attack")
            println("Defense:\t$defense")
            println("Sp.Atk :\t$spatk")
            println("Sp.Def :\t$spdef")
            println("Speed  :\t$speed")
        }
        // MOVES
        //
        // MET DATA
        println("This Pok\u00e9mon was initialized on")
        // TIME
        val birth_time_str = ZonedDateTime.ofInstant(birth_time_instant, ZoneId.of("Z")).format(summary_time_formatter)
        println("=== $birth_time_str" + " UTC")
        // println() learn datetime formatting
        // PLACE
        println("=== In the $birth_place region.")
        // CONDITIONS
        when (birth_path) {
            "nursery" -> println("=== It was hatched in the nursery!")
            "hacked" -> println("=== It was created externally!")
            "starter" -> println("=== It was a starter Pokémon!")
            "elite" -> println("=== It was trained by an elite!")
            else -> println("=== It appeared mysteriously...")
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
