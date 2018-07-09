package com.example.main.thread;

import com.example.main.bean.PublicResource;

/**
 * Created by ls on 18/7/9.
 */
public class ConsumerThread implements Runnable {
    private PublicResource resource;

    public ConsumerThread(PublicResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decrease();
        }
    }
}
