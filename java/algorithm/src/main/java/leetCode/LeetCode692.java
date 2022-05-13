package main.java.leetCode;

import java.util.*;

public class LeetCode692 {
    public static void main(String[] args) {
        System.out.print(topKFrequent(new String[]{
                "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        }, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> rank = new HashMap<>();
        for (String word : words) rank.put(word,rank.getOrDefault(word,0) + 1);
        ArrayList<String> strings = new ArrayList<>();
        rank.forEach((key,value) -> strings.add(key));
        strings.sort((o1, o2) -> rank.get(o1).equals(rank.get(o2)) ? o1.compareTo(o2) : rank.get(o2) - rank.get(o1));
        return  strings.subList(0,k);
    }
}
