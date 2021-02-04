package main.java.leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode224 {
    public static void main(String[] args) {
        int i = 3 - (5 - (8) - (2 + (9 - (0 - (8 - (2)))) - (4)) - (4));

        System.out.println(calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
    }

    public static int calculate(String s) {
        if (s.length() < 2) return Integer.parseInt(s);
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> chars = new Stack<>();

        ArrayList<Character> characters = new ArrayList<Character>() {{
            add('(');
            add(')');
            add('+');
            add('-');
        }};

        int len = s.length();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char val = s.charAt(i);
            if (val == ' ') {
                if (number.length() > 0) {
                    numbers.push(Integer.parseInt(number.toString()));
                    number.delete(0, number.length());
                }
                continue;
            }

            if (characters.contains(val)) {
                if (number.length() > 0) {
                    numbers.push(Integer.parseInt(number.toString()));
                    number.delete(0, number.length());
                }
                if (!chars.isEmpty()) {
                    switch (val) {
                        case '(':
                            chars.push(val);
                            break;
                        case ')':
                            Character operator = chars.peek();
                            if (operator == '(') {
                                chars.pop();
                            }else if (chars.peek() != '('){
                                cacl(numbers, chars);
                            }
                            break;
                        default:
                            operator = chars.peek();
                            if (operator == '(' && numbers.size() > 1) {
                                chars.pop();
                            } else {
                                cacl(numbers, chars);
                            }
                            chars.push(val);
                            break;
                    }
                } else {
                    chars.push(val);
                }
            } else {
                number.append(val);
            }

        }
        if (number.length() > 0) {
            numbers.push(Integer.parseInt(number.toString()));
            number.delete(0, number.length());
        }

        cacl(numbers, chars);
        return numbers.pop();
    }

    private static void cacl(Stack<Integer> numbers, Stack<Character> chars) {
        if (chars.isEmpty()) return;
        int right = numbers.pop();
        int left = 0;

        if (numbers.size() > 0) {
            left = numbers.pop();
        }

        int res = right;

        Character operator = chars.pop();
        switch (operator) {
            case '+':
                res = left + right;
                break;
            case '-':
                res = left - right;
        }
        numbers.push(res);
    }

}
