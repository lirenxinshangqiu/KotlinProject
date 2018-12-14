package com.example.main.book.Queue

import java.lang.Exception

class ArrayQueue {
    private var front: Int
    private var rear: Int
    private var capacity: Int
    private var array: Array<Int>

    private constructor(size: Int) {
        capacity = size
        front = -1
        rear = -1
        array = Array(capacity) { 0 }
    }

    fun isEmpty(): Boolean = front == -1

    fun isFull(): Boolean = (rear + 1) % capacity == front

    fun getQueueSize(): Int = (capacity - front + rear + 1) % capacity

    fun enQueue(data: Int) {
        if (isFull()) {
            throw Exception("Queue Overflow")
        } else {
            rear = (rear + 1) % capacity
            array[rear] = data
            if (front == -1) {
                front = rear
            }
        }
    }

    fun deQueue():Int{
        if (isEmpty()){
            throw Exception("Queue Empty")
        }else{
            val data = array[front]
            front = if (front == rear){
                rear-1
            }else{
                (front+1)%capacity
            }
            return data
        }
    }

    companion object {
        fun createQueue(size: Int): ArrayQueue {
            return ArrayQueue(size)
        }
    }
}

fun main(args: Array<String>) {
    val createQueue = ArrayQueue.createQueue(8)
    (0..7).forEach { createQueue.enQueue(it) }
    (0..7).forEach { _ -> println(createQueue.deQueue()) }
}