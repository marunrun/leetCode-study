package main.java.leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode844 {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
    }

    public static boolean backspaceCompare(String S, String T) {
        return getNewString(S).equals(getNewString(T));
    }

    private static ArrayList<Character> getNewString(String S)
    {
        Stack<Character> one = new Stack<>();
        Stack<Character> backStack = new Stack<>();

        char back = '#';

        for (int i = 0; i < S.length(); i++) {
            one.push(S.charAt(i));
        }

        ArrayList<Character> newS = new ArrayList<>();
        while (!one.isEmpty()) {
            char i = one.pop();
            if (i == back) {
                backStack.push(i);
            } else {
                if (backStack.isEmpty()) {
                    newS.add(i);
                } else {
                    backStack.pop();
                }
            }
        }
        return newS;
    }
}
