package main.java.leetCode;

public class LeetCode81 {
    public static boolean search(int[] nums, int target) {
        int first = nums[0];
        int last = nums[nums.length - 1];

        if (target == first) return true;
        if (target == last) return true;

        // 从左往右
        if (target > first) {

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == target) return true;

                if (nums[i] < nums[i -1]) break;
            }
        }

        //从右往左
        if (target < last) {
            for (int i = nums.length - 2; i > 0; i--) {
                if (nums[i] == target) return true;
                if (nums[i] < nums[i  - 1]) break;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{
               1,0,1,1,1
        },0));
    }
}
