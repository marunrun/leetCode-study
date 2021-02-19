package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode567 {
    public static void main(String[] args) {
        boolean b = checkInclusion(
                "ky",
                "ainwkckifykxlribaypk"
        );
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {

        // 保存s1字串中各个字符出现的次数到字典中
        Map<Character, Integer> charMap = new HashMap<>();
        int s1Len = s1.length();
        for (int i = 0; i < s1Len; i++) {
            charMap.put(s1.charAt(i), charMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tmpMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int len = s2.length();

        while (right < len) {
            char key = s2.charAt(right);

            // 如果当前字符出现在s1的子串中
            if (charMap.containsKey(key)) {
                // 临时字典对应的字符数量+1
                tmpMap.put(key, tmpMap.getOrDefault(key, 0) + 1);
                // 如果当前字符数量比s1子串中的数量还多，那么窗口向右滑动，直到两边数量一致
                while (tmpMap.get(key) > charMap.get(key)) {
                    char leftKey = s2.charAt(left);
                    tmpMap.put(leftKey, tmpMap.get(leftKey) - 1);
                    left++;
                }
            } else {
                // 如果当前字符未出现在s1的子串中，窗口从当前right + 1位置再次滑动。清空临时字典
                tmpMap = new HashMap<>();
                left = right + 1;
            }
            right++;
            // 如果当前窗口的长度大于等于子串的长度就可以直接返回
            if (right - left >= s1Len) {
                return true;
            }
        }

        return false;
    }

}
