package main.java.leetCode;

import java.util.Arrays;

public class LeetCode724 {
    public static void main(String[] args) {
        int[] ints = {-1,-1,-1,-1,-1,-1};
        System.out.println(pivotIndex(ints));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (2 * sum + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }


}
