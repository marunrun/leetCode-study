package main.java.leetCode;

import java.util.Arrays;
import java.util.OptionalInt;

public class LeetCode53 {

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        });
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        while (right < nums.length) {

        }
        return max;
    }
}
