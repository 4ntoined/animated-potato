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
fun codexer (): Array<Array<Double>> {
    val row: Int = 19
    val column: Int = 19
    val codex: Array<DoubleArray> = Array(column) { DoubleArray(row) {1.0} }
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

    
    
    
    

    return codex
}