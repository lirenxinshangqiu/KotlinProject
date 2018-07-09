package test;

/**
 * Created by ls on 18/7/9.
 */
public class ThreadTest {
    public static int count;

    public static void main(String[] args) {
        new MyThread().start();
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable, "线程二").start();

    }

    static class MyThread extends Thread {
        @Override
        public synchronized void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(MyThread.class.getSimpleName() + ":" + Thread.currentThread().getName() + ",count=" + count);
            }
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public synchronized void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(MyRunnable.class.getSimpleName() + ":" + Thread.currentThread().getName() + ",count=" + count);
            }
        }
    }
}
