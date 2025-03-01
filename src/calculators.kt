package com.aarocket.pokemonkt

// used to calculate a pokemon's stats... will make a version to just take the pokemon as input
fun stat_calculation (level: Int,base: Int, IVstat: Int, EVstat: Int, nature: Double): Int {
    val ans = (((2 * base + IVstat + EVstat/4)*level/100.0+5.0)*nature).toInt()
    return ans
}
fun HPstat_calculation (level: Int,base: Int, IVstat: Int, EVstat: Int): Int {
    val ans = (((2 * base + IVstat + EVstat/4)*level/100.0)+level+10).toInt()
    return ans
}
fun typeIndexToString (): List<String> {
    val typeStrings = listOf<String>(
        "Normal",
        "Fire",
        "Water",
        "Grass",
        "Electric",
        "Ice",
        "Fighting",
        "Poison",
        "Ground",
        "Flying",
        "Psychic",
        "Bug",
        "Rock",
        "Ghost",
        "Dragon",
        "Dark", 
        "Steel",
        "Fairy",
        "Typeless"
    )
    return typeStrings
}
fun codexer (): Array<DoubleArray> {
    // normal 0,fire 1,water 2,grass 3,electric 4,ice 5,fighting 6,poison 7,
    // ground 8,flying 9,psychic 10,bug 11,rock 12,ghost 13,dragon 14,dark 15,
    // steel 16,fairy 17,typeless (no relationships) 18
    val codex: Array<DoubleArray> = Array(19) { DoubleArray(19) {1.0} }
    // normal
    codex[0][12]    = 0.5  //rock
    codex[0][13]    = 0.0  //ghost
    codex[0][16]    = 0.5  //steel
    // fire
    codex[1][1]     = 0.5  //fire
    codex[1][2]     = 0.5  //water
    codex[1][3]     = 2.0  //grass
    codex[1][5]     = 2.0  //ice
    codex[1][11]    = 2.0  //bug
    codex[1][12]    = 0.5  //rock
    codex[1][14]    = 0.5  //dragon
    codex[1][16]    = 2.0  //steel
    // water
    codex[2][1]     = 2.0  //fire
    codex[2][2]     = 0.5  //water
    codex[2][3]     = 0.5  //grass
    codex[2][8]     = 2.0  //ground
    codex[2][12]    = 2.0  //rock
    codex[2][14]    = 0.5  //dragon
    // grass
    codex[3][1]     = 0.5 //fire
    codex[3][2]     = 2.0 //water
    codex[3][3]     = 0.5 //grass
    codex[3][7]     = 0.5 //poison
    codex[3][8]     = 2.0 //ground
    codex[3][9]     = 0.5 //flying
    codex[3][11]    = 0.5 //bug
    codex[3][12]    = 2.0 //rock
    codex[3][14]    = 0.5 //dragon
    codex[3][16]    = 0.5 //steel
    // electric
    codex[4][2]     = 2.0 //water
    codex[4][3]     = 0.5 //grass
    codex[4][4]     = 0.5 //electric
    codex[4][8]     = 0.0 //ground
    codex[4][9]     = 2.0 //flying
    codex[4][14]    = 0.5 //dragon
    // ice
    codex[5][1]     = 2.0 //fire
    codex[5][2]     = 0.5 //water
    codex[5][3]     = 2.0 //grass
    codex[5][5]     = 0.5 //ice
    codex[5][8]     = 2.0 //ground
    codex[5][9]     = 2.0 //flying
    codex[5][14]    = 2.0 //dragon
    codex[5][16]    = 0.5 //steel
    // fighting
    codex[6][0]     = 2.0 //normal
    codex[6][5]     = 2.0 //ice
    codex[6][7]     = 0.5 //poison
    codex[6][9]     = 0.5 //flying
    codex[6][10]    = 0.5 //psychic
    codex[6][11]    = 0.5 //bug
    codex[6][12]    = 2.0 //rock
    codex[6][13]    = 0.0 //ghost
    codex[6][15]    = 2.0 //dark
    codex[6][16]    = 2.0 //steel
    codex[6][17]    = 0.5 //fairy
    // poison
    codex[7][3]     = 2.0 //grass
    codex[7][7]     = 0.5 //poison
    codex[7][8]     = 0.5 //ground
    codex[7][12]    = 0.5 //rock
    codex[7][13]    = 0.5 //ghost
    codex[7][16]    = 0.0 //steel
    codex[7][17]    = 2.0 //fairy
    // ground
    codex[8][1]     = 2.0 //fire
    codex[8][3]     = 0.5 //grass
    codex[8][4]     = 2.0 //electric
    codex[8][7]     = 2.0 //poison
    codex[8][9]     = 0.0 //flying
    codex[8][11]    = 0.5 //bug
    codex[8][12]    = 2.0 //rock
    codex[8][16]    = 2.0 //steel
    // flying
    codex[9][3]     = 2.0 //grass
    codex[9][4]     = 0.5 //electric
    codex[9][6]     = 2.0 //fighting
    codex[9][11]    = 2.0 //bug
    codex[9][12]    = 0.5 //rock
    codex[9][16]    = 0.5 //steel
    // psychic
    codex[10][6]    = 2.0 //fighting
    codex[10][7]    = 2.0 //poison
    codex[10][10]   = 0.5 //psychic
    codex[10][15]   = 0.0 //dark
    codex[10][16]   = 0.5 //steel
    // bug
    codex[11][1]    = 0.5 //fire
    codex[11][3]    = 2.0 //grass
    codex[11][6]    = 0.5 //fighting
    codex[11][7]    = 0.5 //poison
    codex[11][9]    = 0.5 //flying
    codex[11][10]   = 2.0 //psychic
    codex[11][13]   = 0.5 //ghost
    codex[11][15]   = 2.0 //dark
    codex[11][16]   = 0.5 //steel
    codex[11][17]   = 0.5 //fairy
    // rock
    codex[12][1]    = 2.0 //fire
    codex[12][5]    = 2.0 //ice
    codex[12][6]    = 0.5 //fighting
    codex[12][8]    = 0.5 //ground
    codex[12][9]    = 0.5 //rock
    codex[12][11]   = 2.0 //bug
    codex[12][16]   = 0.5 //steel
    // ghost
    codex[13][0]    = 0.0 //normal
    codex[13][6]    = 0.0 //fighting
    codex[13][10]   = 2.0 //psychic
    codex[13][15]   = 0.5 //dark
    // dragon
    codex[14][14]   = 2.0 //dragon
    codex[14][16]   = 0.5 //steel
    codex[14][17]   = 0.0 //fairy
    // dark
    codex[15][6]    = 0.5 //fighting
    codex[15][10]   = 2.0 //psychic
    codex[15][13]   = 2.0 //ghost
    codex[15][15]   = 0.5 //dark
    codex[15][17]   = 0.5 //steel
    // steel
    codex[16][1]    = 0.5 //fire
    codex[16][2]    = 0.5 //water
    codex[16][4]    = 0.5 //electric
    codex[16][5]    = 2.0 //ice
    codex[16][12]   = 2.0 //rock
    codex[16][16]   = 0.5 //steel
    codex[16][17]   = 2.0 //fairy
    // fairy
    codex[17][1]    = 0.5 //fire
    codex[17][6]    = 2.0 //fighting
    codex[17][7]    = 0.5 //poison
    codex[17][14]   = 2.0 //dragon
    codex[17][15]   = 2.0 //dark
    codex[17][16]   = 0.5 //steel
    // typeless
    // does neutral (x1.0) damage to every type
    return codex
}

val codex1 = codexer()
val typeStrings = typeIndexToString()