package com.example.main.book.sort


fun main(args: Array<String>) {
    val A = arrayOf(9, 3, 7, 2, 10, 5, 8, 2)
//    bubbleSort(A)
//    bubbleSortImprove(A)
//    selectSort(A)
//    insertSort(A)
    val temp = Array<Int>(A.size) { 0 }
    mergeSort(A, temp, 0, A.size - 1)
    A.print()

}

fun insertSort(array: Array<Int>) {
    if (array.isEmpty()) return
    array.print()
    var temp: Int
    var j: Int
    (1 until array.size).forEach {
        temp = array[it]
        j = it - 1
        while (j >= 0 && array[j] > temp) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = temp
        array.print()
    }
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

fun mergeSort(array: Array<Int>, temp: Array<Int>, left: Int, right: Int) {
    var mid: Int = 0
    if (right > left) {
        mid = (right + left) / 2
        mergeSort(array, temp, left, mid)
        mergeSort(array, temp, mid + 1, right)
        merge(array, temp, left, mid + 1, right)
    }

}

fun merge(array: Array<Int>, temp: Array<Int>, left: Int, mid: Int, right: Int) {
    var left_end = mid - 1
    var leftTemp = left
    var rightTemp = right
    var midTemp = mid
    var tempPose = left
    while ((leftTemp <= left_end) && midTemp <= rightTemp) {
        if (array[leftTemp] <= array[midTemp]) {
            temp[tempPose] = array[leftTemp]
            leftTemp++
        } else {
            temp[tempPose] = array[midTemp]
            midTemp++
        }
        tempPose++
    }
    while (leftTemp <= left_end) {
        temp[tempPose] = array[leftTemp]
        leftTemp++
        tempPose++
    }
    while (midTemp <= rightTemp) {
        temp[tempPose] = array[midTemp]
        midTemp++
        tempPose++
    }

//    temp.forEachIndexed { index, i ->
//        array[index] = i
//    }
    (0 until right - left + 1).forEach {
        array[rightTemp] = temp[rightTemp]
        rightTemp--
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