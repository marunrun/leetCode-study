package main.java.leetCode;

public class LeetCode213 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    static int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{
                1, 2, 3, 4, 5, 1, 2, 3, 4, 5
        }));
    }
}
