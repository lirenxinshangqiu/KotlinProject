package com.example.main.book.sort


fun main(args: Array<String>) {
    val A = arrayOf(9, 3, 7, 2, 10, 5, 8, 2)
//    bubbleSort(A)
//    bubbleSortImprove(A)
    selectSort(A)
    A.print()

}

fun bubbleSort(A: Array<Int>) {
    if (A.isEmpty()) return
    (0 until A.size).forEach { _ ->
        (0 until A.size - 1).forEach {
            if (A[it] > A[it + 1]) {
                val temp = A[it]
                A[it] = A[it + 1]
                A[it + 1] = temp
            }
        }
    }
}

fun bubbleSortImprove(A: Array<Int>) {
    var isSwap: Boolean = true
    run {
        (0 until A.size).forEach { index ->
            println(index)
            (0 until A.size - 1).forEach {
                isSwap = false
                if (A[it] > A[it + 1]) {
                    val temp = A[it]
                    A[it] = A[it + 1]
                    A[it + 1] = temp
                }
                if (isSwap.not()) return@run
            }
        }
    }

}

fun selectSort(A: Array<Int>) {
    var min: Int
    var temp: Int
    (0 until A.size - 1).forEach { i ->
        min = i
        (i + 1 until A.size).forEach { j ->
            if (A[j] < A[min]) {
                min = j
            }
        }
        temp = A[min]
        A[min] = A[i]
        A[i] = temp
    }
}

fun <T> Array<T>.print() {
    val builder = StringBuilder()
    builder.append("[")
    this.forEachIndexed { index, t ->
        builder.append(t)
        if (index != this.size - 1) builder.append(",")
    }
    builder.append("]")
    println(builder.toString())
}