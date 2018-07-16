package com.example.main.datastructure.java.stack;

import java.util.Stack;

/**
 * 是否是一个有效的括号  "[]{}(){[()]}"有效，"{]}"无效
 * Created by ls on 18/7/16.
 */
public class StackSolution {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                Character topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
