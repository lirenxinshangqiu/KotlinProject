package com.example.main

/**
 * Created by ls on 18/4/16.
 */
class InlineFunDemo {
    companion object {
        fun main() {
            val user: User? = User("ls", 18, "beijing")

            //是用let，调用属性的时候必须使用it   适用场景 可空对象判空处理，明确变量所处特定作用域范围内使用
            user?.let {
                print("name:${it.name}\nage:${it.age}\naddress:${it.address}")
            }
            //使用with是，属性需要判空  适用场景：调用一个类中的多个属性
//    with(user){
//        print("name:$name\nage:$age\naddress:$address")
//    }

            //使用run属性，不需要对属性进行判空；run可以适用于let和with对应的所有场景
            user?.run {
                print("name:$name\nage:$age\naddress:$address")
            }

            //和run很像只是返回值不同，apply返回的是对象本身，let/with/run返回的是最后一行代码的值，或者return对应的值  适用场景：对象实例初始化，多层级判空
            user?.apply {
                print("name:${this.name}\nage:$age\naddress:$address")
            }

            //返回对象本身 ,调用属性必须使用it  适用场景：多个函数的链式调用
            user?.also {
                println("name:${it.name}\nage:${it.age}\naddress:${it.address}")
            }

            //如果所给的条件的值为true，返回对象本身，否则返回null
            user?.takeIf { it.address == "beijing" }.run { println(this) }
            println("takeIf")
            user?.takeIf { it.name == "s" }?.run { println(this) }
            println("takeUnless")
            //如果给的条件的值为false,返回对象本身，否则返回null
            user?.takeUnless { it.name == "ls" }?.run { println(this) }
            println("takeUnless")
            user?.takeUnless { it.name == "s" }?.run { println(this) }

        }
    }
}