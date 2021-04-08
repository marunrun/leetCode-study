package main.java.leetCode;

public class LeetCode153 {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{
                3,4,5,1,2
        }));
    }
}
