package main.java.leetCode;

public class LeetCode303 {

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    static class NumArray {

        int[] items;
        int[] sums;

        public NumArray(int[] nums) {
            int n = nums.length;
            sums = new int[n +1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return  sums[j + 1] - sums[i];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{
                -2, 0, 3, -5, 2, -1
        });
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }

}
