package com.example.main.foroffer;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 * 思路：计算字符串中' '字符个数，创建相应char[]，长度为原有字符串长度+空字符*（目标字符数-1）
 */
public class StringReplaceBlank {
    public static void main(String[] args) {
        String content = "We are happy.";
        System.out.println(replaceBlank(content, "%300"));
    }


    private static String replaceBlank(String content, String destStr) {
        if (content == null || content.equals("")) return "";
        int blankLength = calBlankLength(content);
        char[] chars = new char[content.length() + (destStr.length() - 1) * blankLength];//最终字符串字符数组
        System.arraycopy(content.toCharArray(), 0, chars, 0, content.length());//复制数组
        int index = content.length() - 1;//从原有字符串最后一个字符遍历
        int rightIndex = chars.length - 1;//最终字符串指针移到最后一位
        while (index >= 0) {
            if (chars[index] == ' ') {
                for (int i = destStr.length() - 1; i >= 0; i--) {
                    chars[rightIndex--] = destStr.charAt(i);
                }
            } else {
                chars[rightIndex--] = chars[index];
            }
            index--;
        }

        return new String(chars);
    }

    private static int calBlankLength(String content) {
        int count = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == ' ') count++;
        }
        return count;
    }

}

