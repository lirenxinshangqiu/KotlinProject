package test;

/**
 * Created by ls on 18/7/10.
 */
public class SleepInterrupt extends Object implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted with sleeping");
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt interrupt = new SleepInterrupt();
        Thread thread = new Thread(interrupt);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        //中断线程thread
        thread.interrupt();
        System.out.println("in main() - leaving");
    }
}
