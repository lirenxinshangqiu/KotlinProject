package test;

import com.example.main.datastructure.java.queue.ArrayQueue;
import com.example.main.datastructure.java.queue.LinkedListQueue;
import com.example.main.datastructure.java.queue.LoopQueue;
import com.example.main.datastructure.java.queue.Queue;

import java.util.Random;

/**
 * Created by ls on 18/7/16.
 */
public class QueueTest {

    private static double getQueuePopTime(Queue<Integer> queue, int capacity) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            queue.enqueue(random.nextInt());
        }
        for (int i = 0; i < capacity; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {
        int capacity = 10000000;
//        System.out.println("ArrayQueue:" + getQueuePopTime(new ArrayQueue<>(capacity), capacity));
        System.out.println("LoopQueue:" + getQueuePopTime(new LoopQueue<>(capacity), capacity));
        System.out.println("LinkedListQueue:" + getQueuePopTime(new LinkedListQueue<>(), capacity));
    }
}
