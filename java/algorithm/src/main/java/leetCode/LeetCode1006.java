package main.java.leetCode;

import java.util.Stack;

public class LeetCode1006 {

    public static int clumsy(int N) {

        Stack<Integer> integers = new Stack<>();

        for (int i = N; i > 0; i--) {
            switch ((N - i) % 4) {
                case 0:
                    // *
                    if (integers.size() >1) {
                        int b = integers.pop();
                        int a = integers.pop();
                        integers.push(a - b);
                    }
                    integers.push(i);
                    break;
                case 1:
                    // /
                    integers.push(integers.pop() * i);
                    break;
                case 2:
                    // +
                    integers.push(integers.pop() / i);
                    break;
                case 3:
                    // -
                    if (integers.size() >1) {
                        int b = integers.pop();
                        int a = integers.pop();
                        integers.push(a - b);
                    }

                    integers.push(integers.pop() + i);
                    break;
            }
        }
        if (integers.size() >1) {
            int b = integers.pop();
            int a = integers.pop();
            return a- b;
        }

        return integers.pop();
    }

    public static void main(String[] args) {
        int clumsy = clumsy(4);
        System.out.println(clumsy);
    }
}
