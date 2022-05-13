package main.java.leetCode;

import java.util.*;

public class LeetCode1178 {

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask |= (1 << (c - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 0; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);

            res.add(total);
        }
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
