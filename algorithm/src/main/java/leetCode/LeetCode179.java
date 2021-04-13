package main.java.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179 {
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr,(x,y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (numsArr[0] == 0) return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (int num:numsArr) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{
                3, 30
        }));
    }
}
