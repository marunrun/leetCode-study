package main.java.leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode224 {
    public static void main(String[] args) {
        int i = 3 - (5 - (8) - (2 + (9 - (0 - (8 - (2)))) - (4)) - (4));
        System.out.println(i);
        System.out.println(calculate("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4)))"));
    }


    // 更简易的方法
    public static int calculate(String s) {
        // res 保存计算结果。num保存当前值。 sign保存操作符号
        int res = 0, num = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //如果是连续的数字，需要*10 即 进一位
                // 如： 111  第一次计算为 0 * 1 +1 = 1 第二次计算为 1* 10 +1 = 11 第三次计算为 11 * 10 + 1
                // -'0' 是为了得到真正的数字
                num = 10 * num + c - '0';
            } else if (c == '+' || c == '-') {
                res += num * sign;

                // 不再是连续的数字，num清空
                num = 0;
                if (c == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
            } else if (c == '(') {
                // 遇到左括号 将左侧的计算结果和操作符保存下来 并将结果清空
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                // 遇到右括号，将当前计算完成，并将上个左括号之前的结果计算
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        res += sign * num;
        return res;
    }

    // 我是sb 写了一长串 🤐
    public static int calculate2(String s) {
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
                            } else if (chars.peek() != '(') {
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
