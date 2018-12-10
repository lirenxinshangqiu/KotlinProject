package com.example.main.book.stack

import com.example.main.datastructure.java.stack.ArrayStack


class DynArrayStackSolution {
    companion object {
        /**
         * 使用栈来判断括号是否匹配
         */
        fun isCharValid(content: String): Boolean {
            val arrayStack = ArrayStack<Char>()
            val toCharArray = content.toCharArray()
            toCharArray.forEach {
                when (it) {
                    '{', '[', '(' -> arrayStack.push(it)
                    '}', ']', ')' -> {
                        val pop = arrayStack.pop()
                        if (it == '}' && pop != '{') {
                            return false
                        }
                        if (it == ']' && pop != '[') {
                            return false
                        }
                        if (it == ')' && pop != '(') {
                            return false
                        }
                    }
                }
            }

            return arrayStack.isEmpty
        }

        /**
         * 如何用栈实现将中缀表达式变换为后缀表达式
         */

    }
}

fun main(args: Array<String>) {
    val s = "(A+B)+(C-D)"
    val s1 = "((A+B)+(C-D)"
    val s2 = "((A+B)+[C-D])"
    val s3 = "((A+B)+{C-D}"
    println("$s : ${DynArrayStackSolution.isCharValid(s)}")
    println("$s1 : ${DynArrayStackSolution.isCharValid(s1)}")
    println("$s2 : ${DynArrayStackSolution.isCharValid(s2)}")
    println("$s3 : ${DynArrayStackSolution.isCharValid(s3)}")
}