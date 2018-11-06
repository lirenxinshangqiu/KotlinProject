package test

import java.text.DecimalFormat

/**
 * Created by ls on 18/8/6.
 */

fun main(args: Array<String>) {
    println("maxSum = ${getMaxSum(intArrayOf(1, -2, 3, 10, -4, 7, 2, -5))}")
    println("maxSum = ${getMaxSum(intArrayOf(-1,-2,-3,-4 -5))}")
    println("maxSum = ${getMaxSum(intArrayOf(1,2,3,4,5))}")
    val format = DecimalFormat("###,###").format(0)
    println(format)
}

fun getMaxSum(intArray: IntArray): Int {
    var sum = 0
    var max = intArray[0]
    intArray.forEach {
        if (sum < 0) {
            sum = it
        } else {
            sum += it
        }
        if (sum > max) {
            max = sum
        }
    }
    return max

}