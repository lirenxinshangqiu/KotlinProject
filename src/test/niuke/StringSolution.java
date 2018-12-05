package test.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSolution {
    public static void stringSplite(String content) {
        if (content == null || "".equals(content)) return;
        String[] s = content.split(" ");
        int length = s.length;
        StringBuilder builder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            builder.append(s[i]).append(" ");
        }
        System.out.print(builder.toString().trim());
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String read = bufferedReader.readLine();
//        String[] s = read.split(" ");
//        System.out.println(calHeightOfTree(Integer.parseInt(s[0])));
//        String content = bufferedReader.readLine();
//        String[] s = content.split(" ");
//        int length = s.length;
//        StringBuilder builder = new StringBuilder();
//        for (int i = length - 1; i >= 0; i--) {
//            builder.append(s[i]).append(" ");
//        }
//        System.out.print(builder.toString().trim());
        System.out.println(calHeightOfTree(291));
    }

    public static long calHeightOfTree(int n) {
       long sum = 1;
       long count = 1;
       while (2*sum-1<n){
           sum*=2;
           count++;
       }
       return count;
    }
}
