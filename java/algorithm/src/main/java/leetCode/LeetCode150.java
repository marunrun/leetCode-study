package main.java.leetCode;

import java.util.Stack;

public class LeetCode150 {

    /**
     * 根据 逆波兰表示法，求表达式的值。
     * <p>
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * <p>
     *  
     * <p>
     * 说明：
     * <p>
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     * <p>
     * 输入：tokens = ["4","13","5","/","+"]
     * 输出：6
     * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> integers = new Stack<>();
//        Stack<String> operations = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int b = integers.pop();
                    int a = integers.pop();
                    integers.push(a + b);
                    break;
                case "-":
                    b = integers.pop();
                    a = integers.pop();
                    integers.push(a - b);
                    break;
                case "*":
                    b = integers.pop();
                    a = integers.pop();
                    integers.push(a * b);
                    break;
                case "/":
                    b = integers.pop();
                    a = integers.pop();
                    integers.push(a / b);
                    break;
                default:
                    integers.push(Integer.valueOf(token));
            }
        }
        return integers.peek();
    }

    public static void main(String[] args) {
        int i = evalRPN(new String[]{
                "4","13","5","/","+"
        });
        System.out.println(i);
    }
}
