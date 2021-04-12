package main.java.leetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LeetCode264 {
    public static int nthUglyNumber(int n) {
        if (n < 1) return n;
        int[] nums = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            res = (int) curr;
            for (int num : nums) {
                long next = curr * num;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
