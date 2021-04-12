package main.java.leetCode;

public class LeetCode153 {

    public static int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) return  nums[0];
        if (n == 2) return Math.min(nums[0],nums[1]);
        int min = nums[n - 1];
        int max = nums[0];
        if (min > max) return max;
        if (min < nums[n -2]) return  min;

        int mid = n / 2;
        int left = 0;
        int right = n;
        while (nums[mid] > nums[mid - 1] || nums[mid] > nums[mid + 1]) {
            if (nums[mid] > max) {
                left = mid;
                mid = (right + left) / 2;
                continue;
            }

            if (nums[mid] < min) {
                right = mid;
                mid =(right + left) / 2;
            }

        }

        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{
                2,2,2,0,1
        }));
    }
}
