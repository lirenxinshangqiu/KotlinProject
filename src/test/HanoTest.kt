package test

import test.niuke.StringSolution

fun main(args: Array<String>) {
    runtimeCal {
        HanoSolution().hano(5, "a", "b", "c")
    }
    StringSolution.stringSplite("I like beijing.")

}

class HanoSolution() {
    fun hano(n: Int, from: String, to: String, aux: String) {
        if (n <= 1) {
            println("$from->$to")
        } else {
            hano(n - 1, from, aux, to)
            hano(1, from, to, aux)
            hano(n - 1, aux, to, from)
        }
    }


}

class StringSolution {
    fun strSplite(content: String) {
        val split = content.split(" ")
        split?.reversed().forEachIndexed { index: Int, s: String ->
            print(s)
            if (index < split.size-1)
                print(" ")
        }
    }
}