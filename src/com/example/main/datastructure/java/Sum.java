package com.example.main.datastructure.java;

public class Sum {
    public static int sum(int[] arry) {
        return sum(arry, 0);
    }

    public static int sum(int[] array, int l) {
        if (l == array.length) return 0;
        return array[l] + sum(array, l + 1);
    }



    public static void main(String[] args) {
        int sum = sum(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(sum);
        System.out.println(reverseString("Hello Android!1"));
        System.out.println(reverseStringByArray("Hello An droid!1"));
    }

    /**
     * 递归方法反转字符串
     *
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if (str.length() <= 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /**
     * 数组反转字符串
     * @param str
     * @return
     */
    public static String reverseStringByArray(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < (length + 1) / 2; i++) {
            char cha = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = cha;
        }
        return new String(chars);
    }
    //逆序反转不写了


}
