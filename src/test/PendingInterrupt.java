package test;

/**
 * Created by ls on 18/7/10.
 */
public class PendingInterrupt extends Object {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("point a :t.isInterrupted() = "+t.isInterrupted());
        t.interrupt();
        System.out.println("point b :t.isInterrupted() = "+t.isInterrupted());
        System.out.println("point c :t.isInterrupted() = "+t.isInterrupted());
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("was not interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }
        System.out.println("执行时间：" + (System.currentTimeMillis() - startTime));
        System.out.println("point d :t.isInterrupted() = "+t.isInterrupted());
    }
}
