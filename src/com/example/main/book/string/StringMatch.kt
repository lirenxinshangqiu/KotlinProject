package com.example.main.book.string

/**
 * 字符串匹配算法
 */
fun main(args: Array<String>) {
    val source = "abcdefg"
    val content = "bc"
    println(source.brueStringMatch(content))

    permutationsInOrder("aabc")
    println("===========")
    permutationsNotInOrder("aabc")
}

/**
 * 蛮力法
 */
fun String.brueStringMatch(content: String?): Int {
    content ?: return -1
    if (content.length > this.length) return -1
    if (content.length == this.length) {
        return if (this == content) 0 else -1
    }
    var index = -1
    kotlin.run breaking@{
        (0..this.length - content.length).forEach {
            if (this.substring(it, it + content.length) == content) {
                index = it
                return@breaking
            }
        }
    }
//    val sourceArray = this.toCharArray()
//    val contentArray = content.toCharArray()
//    kotlin.run breaking@{
//        (0..sourceArray.size - contentArray.size).forEach {
//            index = it
//            var j = 0
//            while (j < contentArray.size && sourceArray[index + j] == contentArray[j]) {
//                j++
//            }
//            if (j == contentArray.size) return@breaking
//        }
//    }

    return index
}


/**
 * 返回字符串的组合
 */
fun permutationsInOrder(content: String) {
    preMutationsInOrder("", content)
}

private fun preMutationsInOrder(prefix: String, content: String) {
    val length = content.length
    if (length == 0) {
        println(prefix)
    } else {
        (0 until length).forEach {
            preMutationsInOrder(prefix + content[it], content.substring(0, it) + content.substring(it + 1, length))
        }
    }
}

fun permutationsNotInOrder(content: String) {
    val array = Array<Char>(content.length) { ' ' }
    (0 until content.length).forEach {
        array[it] = content[it]
    }
    permutationsNotInOrder(array, content.length)
}

fun <T> Array<T>.print() {
    val builder = StringBuilder()
    builder.append("[")
    this.forEachIndexed { index, t ->
        builder.append(t)
        if (index < this.size - 1) {
            builder.append(",")
        }
    }
    builder.append("]")
    println(builder.toString())
}

private fun permutationsNotInOrder(array: Array<Char>, n: Int) {
    if (n == 1) {
        array.print()
        return
    }

    (0 until n).forEach {
        swap(array, it, n - 1)
        permutationsNotInOrder(array, n - 1)
        swap(array, it, n - 1)
    }

}

private fun swap(array: Array<Char>, i: Int, j: Int) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}