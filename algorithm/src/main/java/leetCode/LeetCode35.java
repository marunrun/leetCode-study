package main.java.leetCode;

public class LeetCode35 {
    public static void main(String[] args) {
        System.out.print(searchInsert(new int[]{
                1, 3, 5, 6
        }, 5));
    }

    public static int searchInsert(int[] nums, int target) {
   /*     // 迭代
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }

        return n;*/

        //二分查找
        int n = nums.length;
        int left = 0, right = n - 1;
        if (nums[left] > target) return left;
        if (nums[right] < target) return n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
