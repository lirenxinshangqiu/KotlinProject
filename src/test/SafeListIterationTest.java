package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ls on 18/7/10.
 */
public class SafeListIterationTest {
    private static List<String> list = new ArrayList<>();
    private static List<String> newList;

    public static void main(String[] args) {
        newList = Collections.synchronizedList(list);
        for (int i = 0; i < 1000; i++) {
            newList.add(String.format("item%02d", i + 1));
        }
        MyRunnable myRunnable = new MyRunnable(newList.iterator());
        new Thread(myRunnable, "线程一").start();
        new Thread(myRunnable, "线程二").start();
        new Thread(myRunnable, "线程三").start();

    }

    public static class MyRunnable implements Runnable {
        Iterator<String> iterator;

        public MyRunnable(Iterator<String> iterator) {
            this.iterator = iterator;
        }

        @Override
        public void run() {
            synchronized (iterator) {

                while (iterator.hasNext()) {
                    String next = iterator.next();
                    System.out.println("found string:" + next + "-----" + Thread.currentThread().getName());
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
