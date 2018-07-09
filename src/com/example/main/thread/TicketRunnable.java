package com.example.main.thread;

/**
 * Created by ls on 18/7/9.
 */
public class TicketRunnable implements Runnable {
    private int ticket = 100;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}
