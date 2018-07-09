package com.example.main.bean;

/**
 * Created by ls on 18/7/9.
 */
public class PublicResource {
    private int number = 0;
    private int size = 10;

    /**
     * 增加公共资源
     */
    public synchronized void increase() {
        while (number >= size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("生产了1个，共有+" + number);
        notifyAll();
    }

    public synchronized void decrease() {
        while (number <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number--;
        System.out.println("消费了1个，总共有" + number);
        notifyAll();
    }
}
