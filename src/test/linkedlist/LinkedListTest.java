package test.linkedlist;


import com.example.main.datastructure.java.linklist.LinkedList;
import com.example.main.datastructure.java.stack.ArrayStack;
import com.example.main.datastructure.java.stack.LinkedListStack;
import com.example.main.datastructure.java.stack.Stack;

import java.util.Random;

/**
 * Created by ls on 18/7/17.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
//            System.out.println(linkedList);
        }
        System.out.println(linkedList);
//        linkedList.remove(1);
//        System.out.println(linkedList);
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList);
        long count = 100000;
        System.out.println("LinkedListStack:" + testStack(new LinkedListStack<Integer>(), count));
        System.out.println("ArrayListStack:" + testStack(new ArrayStack<>(), count));
    }

    private static double testStack(Stack<Integer> stack, long count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (long i = 0; i < count; i++) {
            stack.pop();
        }
        return (System.nanoTime() - startTime) / 1000000000.0;
    }
}
