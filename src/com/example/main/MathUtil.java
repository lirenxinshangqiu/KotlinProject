package com.example.main;

/**
 * Created by ls on 18/7/2.
 */
public class MathUtil {
    private static double ZERO = 0.0000001;

    public static double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if (equal(base, ZERO) && exponent <= 0) {
            throw new Exception("0的负次幂无意义");
        }
        if (equal(exponent, 0)) {
            return 1;
        }
        if (exponent < 0) {
            result = powerWithExponent(1 / base, -exponent);
        } else {
            result = powerWithExponent(base, exponent);
        }
        return result;
    }

    private static double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 两个值在误差允许范围内相等
     *
     * @param num1
     * @param num2
     * @return
     */
    private static boolean equal(double num1, double num2) {
        return num1 - num2 <= ZERO && num1 - num2 >= -ZERO;
    }
}
