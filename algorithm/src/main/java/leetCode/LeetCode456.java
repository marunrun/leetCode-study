package main.java.leetCode;

public class LeetCode456 {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int first = 0;
        int second = 1;
        int third = 2;

        while (first < n ) {
            if (third >= n || second >= n) {
                first++;
                second = first+1;
                third = second +1;
                continue;
            }
            if (nums[second] < nums[first]) {
                second++;
                third++;
                continue;
            }

            if (nums[second] < nums[third]) {
                second++;
                third++;
                continue;
            }

            if (nums[third] <= nums[first]) {
                third++;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{
                -2,1,1
        }));
    }
}
