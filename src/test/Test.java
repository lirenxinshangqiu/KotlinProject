package test;

import com.example.main.*;

import java.io.*;
import java.util.HashMap;

/**
 * Created by ls on 18/6/22.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(ConstTest.name);
        System.out.println(ConstTest.INSTANCE.getName1());
        System.out.println(ConstCompaionTest.name);
        System.out.println(ConstCompaionTest.Companion.getName1());
        clacleteShl(30);
        testTransient();
        int[] array = createArray(1000);
        long startTime = System.currentTimeMillis();
        SortDemo.bubbleSort(array);
        System.out.println("冒泡排序时间："+(System.currentTimeMillis()-startTime));
        long startTime1 = System.currentTimeMillis();
        SortDemo.selectSort(array);
        System.out.println("选择排序时间："+(System.currentTimeMillis()-startTime1));
//        for (int i = 0; i < array.length; i++) {
//            int index = SortDemo.binarySearch(array, array[i]);
//            System.out.println("value = " + array[i] + ",index = " + index);
//        }
        int[] preorder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        try {
            BinaryTreeNode binaryTreeNode = BinaryTreeSolution.constructCore(preorder, inorder);
            BinaryTreeSolution.printBinary(binaryTreeNode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            double result = MathUtil.power(10, 10);
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] card = new int[]{0, 2, 4, 7, 5, 6, 0, 2};
        System.out.println(CardContinueSolution.isContinue(card) ? "是顺子" : "不是顺子");
        int n = 5;
        int m = 3;
        System.out.println("n=" + n + ",m=" + m + "剩下的最后一个数：" + lastReaminning(n, m));
        int[] array1 = new int[]{2, 4, 7, 11, 16};
        calTargetInArray(array1, 9);
    }

    private static int[] createArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random()*n+1);
        }
        return array;
    }

    private static int lastReaminning(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    private static void calTargetInArray(int[] array, int target) {
        if (array == null) {
            System.out.println("数组为空！");
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {
                System.out.println("index1 = " + (map.get(array[i]) + 1) + ",index2 = " + (i + 1) + ",target=" + target);
            } else {
                map.put(target - array[i], i);
            }
        }

    }

    private static void testTransient() {
        Person person = new Person("ls", 10, "lkll");
        System.out.println("before read person");
        System.out.println(person);
        String pathname = "/Users/wenbaoxing/Documents/ls/user.txt";
        File file = new File(pathname);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathname));
            oos.writeObject(person);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathname));
            Person user = (Person) ois.readObject();
            System.out.println("序列化之后");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void clacleteShl(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(1 << i);
        }

        System.out.println("--------");
        for (int i = 0; i <= n; i++) {
            System.out.println(1 >> i);
        }


    }

}
