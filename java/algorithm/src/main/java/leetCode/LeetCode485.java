package main.java.leetCode;

public class LeetCode485 {
    public static void main(String[] args) {
        int maxConsecutiveOnes = findMaxConsecutiveOnes(new int[]{
                1, 1, 0, 1, 1, 1
        });
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int left =0,right =0,max = 0;

        while (right < nums.length) {
            if (nums[right] ==0) {
                left = right+1;
            }
            right++;
            max = Math.max(max,right - left);
        }

        return max;
    }
}
