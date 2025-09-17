package com.aarocket.pokemonkt

val mainmenu = "[quit]\n\n[P] Pok\u00e9mon\n[B] Battle!\n"
//val codex1 = codexer()

fun main() {
    while (true)  {
        print("$mainmenu\nWhere to?: ")
        val input000 = readlnOrNull()

        if ((input000 == "p") || (input000 == "P")) {
            while (true) {
                val mon1 = mon("Dolly",saiv=31,type1=17,type2=4,nature_up=2,nature_down=1)
                mon1.summary(inBattle=true)
                val mon2 = make_fromdex(level=600,nature_up=2,birth_path="elite")
                mon2.summary()
                val mon3 = make_fromdex(dexnumber=900,level=600,nature_down=3,birth_path="elite")
                mon3.summary()
                val mon4 = make_fromdex(level=600,nature_down=3,birth_path="elite")
                mon4.summary()
                println(pokedex[0])
                print("Now what...\n: ")
                val inputpoke1 = readlnOrNull()
                if ((inputpoke1=="b") || (inputpoke1=="B")) {
                    break
                }
            }
        }

        if ((input000 == "a") || (input000 == "A")) {
            while (true) {
                println("You triggered a cutscene!\n: ")
                val input001 = readlnOrNull()
                if (input001 == "b") {
                    println("break...")
                    break
                }
            }
        }


        if ((input000 == "quit") || (input000 == "QUIT")) {
            println("Thanks for playing!")
            break
        }
    }
}
