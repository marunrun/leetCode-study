package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        //todo
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < text2.length(); i++) {
            charMap.putIfAbsent(text2.charAt(i), i);
        }
        int max = 0;

        for (int i = 0; i < chars1.length; i++) {
            int cur = 0;
            if (charMap.containsKey(chars1[i])) {
                cur++;
                int pre = i;
                for (int j = i + 1; j < chars1.length; j++) {
                    if (charMap.containsKey(chars1[j]) && charMap.get(chars1[j]) > charMap.get(chars1[pre])) {
                        cur++;
                        pre = j;
                    }

                }
            }
            max = Math.max(max, cur);
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence(
                "abcba",
                "abcbcba"
        ));
    }

}
