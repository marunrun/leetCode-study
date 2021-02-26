package main.java.leetCode;

import java.util.*;

public class LeetCode1178 {

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public static void main(String[] args) {
        List<Integer> numOfValidWords = findNumOfValidWords(new String[]{
                "aaaa", "asas", "able", "ability", "actt", "actor", "access"
        }, new String[]{
                "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"
        });
        System.out.println(numOfValidWords);
    }
}
