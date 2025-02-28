package com.aarocket.pk

fun main() {
	while (1==1)  {
		print("This is the game!\nWhere to?: ")
		val input_000 = readLine()
		
		if ((input_000 == "a") || (input_000 == "A")) {
			while (1==1) {
				println("You triggered a cutscene!\n: ")
				val input_001 = readLine()
				if (input_001 == "b") {
					println("break...")
					break
				}
			}
		}


		if ((input_000 == "quit") || (input_000 == "QUIT")) {
			println("Thanks for playing!")
			break
		}
	}
}

