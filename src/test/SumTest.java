package test;

/**
 * Created by ls on 18/7/12.
 */
public class SumTest {
    public static void main(String[] args) {
        long n = 1000000000L;
        long start = System.currentTimeMillis();
        sum1(n);
        System.out.println("sum1时间：" + (System.currentTimeMillis() - start));
        long start1 = System.currentTimeMillis();
        sum2(n);
        System.out.println("sum2时间：" + (System.currentTimeMillis() - start1));
    }

    private static void sum1(long n) {
        long sum = 0;
        for (long i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    private static void sum2(long n) {
        long sum = (1 + n) * n / 2;
        System.out.println("sum = " + sum);
    }
}
