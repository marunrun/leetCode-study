package main.java.leetCode;

import java.util.*;

public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> leftStack = new Stack<>();
        ArrayList<Character> leftChar = new ArrayList<>();
        leftChar.add((char) 40);
        leftChar.add((char) 91);
        leftChar.add((char) 123);

        ArrayList<Character> rightChar = new ArrayList<>();
        rightChar.add((char) 41);
        rightChar.add((char) 93);
        rightChar.add((char) 125);


        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (leftChar.contains(aChar)) {
                leftStack.push(aChar);
            } else {
                if (leftStack.isEmpty() || leftChar.indexOf(leftStack.pop()) != rightChar.indexOf(aChar)) {
                    return false;
                }
            }
        }

        return leftStack.isEmpty();
    }

    public static boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        HashMap<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        stack.add('c');
        stack.push('c');

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

        }

        return true;
    }
}
