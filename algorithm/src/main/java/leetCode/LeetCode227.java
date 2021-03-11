package main.java.leetCode;

import java.util.Stack;

public class LeetCode227 {

    public static void main(String[] args) {
        int calculate = calculate("14/3*2");
        System.out.println(calculate);
    }

    public static int calculate(String s) {
        Stack<Integer> integers = new Stack<>();
        Stack<Character> characters = new Stack<>();
        int len = s.length();
        int num = 0;
        for (int i = 0; i < len; i++) {
            char val = s.charAt(i);
            if (val == ' ') {
                continue;
            }
            if (Character.isDigit(val)) {
                num = num * 10 + val - '0';
            } else {
                integers.push(num);
                num = 0;

                while (!characters.isEmpty() && (val != '/' && val != '*' || (characters.peek() == '/' || characters.peek() == '*'))) {
                    integers.push(cal(integers, characters));
                }

                characters.push(val);
            }
        }
        integers.push(num);
        while (!characters.isEmpty()) {
            integers.push(cal(integers, characters));
        }
        return integers.pop();
    }

    private static int cal(Stack<Integer> integers, Stack<Character> characters) {
        char ope = characters.pop();
        int b = integers.pop();
        int a = integers.pop();
        switch (ope) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}
