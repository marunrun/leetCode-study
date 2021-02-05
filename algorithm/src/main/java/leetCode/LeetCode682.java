package main.java.leetCode;

import java.util.Stack;

public class LeetCode682 {

    public static void main(String[] args) {
        int i = calPoints(new String[]{"1"});
        System.out.println(i);
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String val : ops) {
            if (stack.isEmpty()) {
                stack.push(Integer.parseInt(val));
                sum += stack.peek();
                continue;
            }
            switch (val) {
                case "+":
                    Integer second = stack.pop();
                    Integer first = stack.peek();
                    stack.push(second);
                    stack.push(second + first);
                    sum += stack.peek();
                    break;
                case "D":
                    first = stack.peek();
                    stack.push(first * 2);
                    sum += stack.peek();
                    break;
                case "C":
                    Integer pop = stack.pop();
                    sum -= pop;
                    break;
                default:
                    stack.push(Integer.parseInt(val));
                    sum += stack.peek();
                    break;
            }

        }

        return sum;
    }
}
