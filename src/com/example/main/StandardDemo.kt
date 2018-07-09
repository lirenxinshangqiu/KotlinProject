package com.example.main

import java.util.*

/**
 * Created by ls on 17/12/5.
 */
class StandardDemo {
    companion object {
        fun main() {
            val month = "(JAN|FEB|MAR)"
            println("""\d{2}$month\d{4}""")
            val list = arrayListOf(1, 2, 3, 4, 5, 6)
            list.filter { it > 4 }.map { User("ls", it, "kdkdk") }.forEach(::println)
//            (0..10).map { Person("ls",10) }.forEach(::println)
            val hashSet = HashSet<Person>()
            (0..10).forEach { hashSet.add(Person("ls", 10)) }
            hashSet.forEach(::println)

            val a = "ab"
            val b = String("ab".toCharArray()).intern()
            val c = String("ab".toCharArray())
            println("a==b:${a == b}\n a==c:${a == c}\nb==c:${b == c}")
            val arrayListOf = arrayListOf<String?>()
//            Thread {
//                kotlin.run {
//                    (0 until 1000).forEach {
//                        arrayListOf.add(it.toString())
//                        Thread.sleep(1)
//                    }
//                }
//            }.start()
//            Thread {
//                kotlin.run {
//                    (1000 until 2000).forEach {
//                        arrayListOf.add(it.toString())
//                        Thread.sleep(1)
//                    }
//                }
//            }.start()
//            Thread.sleep(10000)
//            arrayListOf.forEach(::println)

            val size = 8
            println("size shr 1 = ${size shr 2}")
            println("size shl 1 = ${size shl 2}")
        }
    }


}