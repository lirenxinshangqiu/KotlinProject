package test.stack;

import com.example.main.datastructure.java.stack.ArrayStack;
import com.example.main.datastructure.java.stack.StackSolution;

/**
 * Created by ls on 18/7/16.
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        String str = "{{{[]()()}}}";
        StackSolution stackSolution = new StackSolution();
        System.out.println(stackSolution.isValid(str) ? "有效" : "无效");
    }
}
