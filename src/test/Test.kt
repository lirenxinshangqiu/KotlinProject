package test

import com.example.main.*

/**
 * Created by ls on 18/3/28.
 */

fun main(args: Array<String>) {
    StandardDemo.main()
//    OprationDemo.main()
//    LambdaDemo().setListener { print("kdkd") }
//    LambdaDemo().setFaildListener { exception -> print(exception.localizedMessage) }
////    FileIODemo.main()
////    InlineFunDemo.main()
//    val a = 3
//    val b = 2
//    val max = if (a > b) {
//        println("a=$a")
//        a
//    } else {
//        println("b = $b")
//        b
//    }
//    println("max = $max")
//    val sum = { x: Int, y: Int -> x + y }
//    fun add(f: (Int) -> Int) = f(10) * 2
//    val x = add { sum(1, 2) }
//    println("x=$x")
//    printIndent()
//    Array(10, { i -> i * i }).forEach(::println)
    println(ConstTest.name)
    println(ConstTest.name1)
}

private fun printIndent() {
    val text = """
    |理论
|实践
|真知"""
    println(text.trimMargin())
    println(text.trimIndent())
    val valueOf = ProtocolState.valueOf("Taking")
    println(valueOf)
}

object ConstTest {
    const val name = "ls"
    val name1 = "ls"
}

class ConstCompaionTest {
    companion object {
        const val name = "ls"
        val name1 = "ls"
    }
}

