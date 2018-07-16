package test.array;

import com.example.main.User;
import com.example.main.datastructure.java.array.Array;

/**
 * Created by ls on 18/7/16.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 20);
        System.out.println(array);
        array.addFirst(10);
        System.out.println(array);

        System.out.println(array.remove(0));
        System.out.println(array.remove(0));
        System.out.println(array);
        Array<User> userArray = new Array<>();
        User user = new User("ls", 1, "sss");
        userArray.addFirst(user);
        userArray.addFirst(user);
        userArray.addFirst(user);
        System.out.println(userArray);
    }
}
