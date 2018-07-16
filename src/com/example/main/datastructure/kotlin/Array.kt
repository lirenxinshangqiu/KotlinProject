package com.example.main.datastructure.kotlin

/**
 * Created by ls on 18/7/16.
 */
class Array constructor(var capacity: Int) {
    private var data: IntArray = kotlin.IntArray(capacity)
    private var size: Int = 0

    init {
        size = 0
    }

    constructor() : this(10)

    fun getSize() = size

    fun getLength() = data.size

    fun isEmpty() = size == 0

}