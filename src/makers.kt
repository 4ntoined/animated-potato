package com.aarocket.pokemonkt

fun make_fromdex(
    dexnumber: Int = (0..n_pokedex-1).toList().random(),
    level: Int = 100,
    nature_up: Int = (0..4).toList().random(),
    nature_down: Int = (0..4).toList().random(),
    birth_path: String = "hacked",
    nickname: String = "",
    random: Boolean = false
) : mon {
    val dexdata = pokedex[dexnumber]
    var named = dexdata.species
    if (nickname!=""){
        named = nickname
    }
    val mademon = mon(
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
