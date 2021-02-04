package main.java.leetCode;

public class LeetCode424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABCABBB", 2));
    }

    public static int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] map = new int[26];

        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if (right - left + 1 > historyCharMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }

}
