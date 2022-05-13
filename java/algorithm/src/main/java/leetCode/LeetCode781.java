package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode781 {

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger count = new AtomicInteger();
        for (int num : answers) {
            if (num == 0) {
                count.getAndIncrement();
                continue;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map.forEach((num, sum) -> {
            count.addAndGet(sum / (num + 1) * (num + 1));
            if (sum % (num + 1) != 0) {
                count.addAndGet(num + 1);
            }
        });
        return count.get();
    }

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{
                0, 0, 1,  0,
        }));
    }
}
