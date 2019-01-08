package com.example.main.book.sort


fun main(args: Array<String>) {
    val A = arrayOf(9, 3, 7, 2, 10, 5, 8, 2)
//    bubbleSort(A)
//    bubbleSortImprove(A)
//    selectSort(A)
//    insertSort(A)
//    val temp = Array<Int>(A.size) { 0 }
//    mergeSort(A, temp, 0, A.size - 1)
    quickSort(A, 0, A.size - 1)
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

/**
 * 归并排序
 */
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


    //必须分开，不能直接复制temp数组中的值
    (0 until right - left + 1).forEach {
        array[rightTemp] = temp[rightTemp]
        rightTemp--
    }


}


/**
 * 快速排序
 */
fun quickSort(array: Array<Int>, low: Int, high: Int) {
    var piovt: Int
    if (high > low) {
        piovt = partition(array, low, high)
        quickSort(array, low, piovt - 1)
        quickSort(array, piovt + 1, high)
    }
}

fun partition(array: Array<Int>, low: Int, high: Int): Int {
    var left = low
    var right = high
    var pivotItem = array[low]
    while (left < right) {
        while (array[left] <= pivotItem) {
            left++
        }
        while (array[right] > pivotItem) {
            right--
        }
        if (left < right) {
            var aTemp = array[left]
            array[left] = array[right]
            array[right] = aTemp
        }
    }
    array[low] = array[right]
    array[right] = pivotItem
    return right

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

/**
 * 给定数组A[0...n-1],其中每个元素代表选举中的一张选票，假设每张选票以一个整数来表示候选人的ID,给出一个算法来判定谁赢得选举
 */
private fun checkWhoWinsTheElection(array: Array<Int>, n: Int): Int {
    var counter = 0
    var maxCounter = 0
    var candidate: Int = array[0]
    array.forEachIndexed { index, i ->
        counter = 0
        (index + 1 until n).forEach {
            if (array[index] == it) {
                counter++
            }
        }
        if (counter > maxCounter) {
            maxCounter = counter
            candidate = array[index]
        }
    }
    return candidate
}