package test;

import java.util.Stack;

/**
 * Created by ls on 18/7/3.
 */
public class GetMinStack {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public Integer getmin() {
            if (stackMin == null) {
                throw new RuntimeException("stackMin is empty!");
            }
            return ((Integer) stackMin.peek());
        }

        public void push(Integer value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (value < getmin()) {
                stackMin.push(value);
            }
            stackData.push(value);
        }

        public Integer pop() {
            Integer num = stackData.pop();
            if (num == getmin()) {
                return stackMin.pop();
            }
            return num;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println("最小值：" + myStack.getmin());
        myStack.push(4);
        System.out.println("最小值：" + myStack.getmin());
        myStack.push(1);
        myStack.push(2);
        System.out.println("最小值：" + myStack.getmin());
        System.out.println(myStack.pop());
        System.out.println("最小值：" + myStack.getmin());
        System.out.println(myStack.pop());
        System.out.println("最小值：" + myStack.getmin());
        System.out.println(myStack.pop());
        System.out.println("最小值：" + myStack.getmin());
        System.out.println(myStack.pop());


    }
}
