package com.aarocket.pokemonkt

import kotlin.random.Random

fun make_fromdex(
    dexnumber: Int = (0..n_pokedex-1).toList().random(),
    level: Int = 100,
    nature_up: Int = (0..4).toList().random(),
    nature_down: Int = (0..4).toList().random(),
    birth_path: String = "hacked",
    nickname: String = "",
    random: Boolean = false
) : Mon {
    val dexdata = pokedex[dexnumber]
    var named = dexdata.species
    if (nickname!=""){
        named = nickname
    }
    val mademon = Mon(
        name = named,
        level = level,
        hpb = dexdata.hp,
        atb = dexdata.at,
        deb = dexdata.de,
        sab = dexdata.sa,
        sdb = dexdata.sd,
        spb = dexdata.sp,
        type1 = dexdata.type1,
        type2 = dexdata.type2,
        nature_up = nature_up,
        nature_down = nature_down,
        birth_path = birth_path
        )
    return mademon
}

fun make_random_party(
    //dexnumbers = List(0){},
    number: Int = 6,
    level: Int = 100,
    birth_path: String = "random",
) : MutableList<Mon> {
    val indexes = List(number) {Random.nextInt(0,n_pokedex)}
    val party = mutableListOf<Mon> ()
    indexes.forEach {
        party += make_fromdex(dexnumber = it, level = level, birth_path = birth_path,)
    }
    return party
}
