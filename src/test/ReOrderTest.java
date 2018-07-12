package test;

/**
 * Created by ls on 18/7/11.
 */
public class ReOrderTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        OrderEven orderEven = new OrderEven();
        arr = reOrderArray1(arr, orderEven);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] arr1 = {2, 4, 6, 8, 1, 3, 5, 7, 9};
        arr1 = reOrderArray(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        int[] arr2 = {2, 4, 6, 8, 10};
        arr2 = reOrderArray(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        try {
            int d = 1/0;
        } finally {
            System.out.println("123444");
        }
    }

    private static int[] reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp % 2 == 1) {
                for (int j = i; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            } else {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        }

        return array;

    }

    private static int[] reOrderArray1(int[] array, ICheck iCheck) {
        int odd = 0;
        int even = array.length - 1;
        while (odd < even) {
            while (odd < even && !iCheck.function(array[odd])) {
                odd++;
            }
            while (odd < even && iCheck.function(array[even])) {
                even--;
            }
            int temd = array[odd];
            array[odd] = array[even];
            array[even] = temd;
        }
        return array;
    }

    public static class OrderEven implements ICheck {

        @Override
        public boolean function(int n) {
            return n % 2 == 0;
        }
    }

    interface ICheck {
        boolean function(int n);
    }
}
