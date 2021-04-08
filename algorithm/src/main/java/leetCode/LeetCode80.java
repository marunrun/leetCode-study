package main.java.leetCode;

public class LeetCode80 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int slow = 2;
        int fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{
                0,0,1,1,1,2,2,3,3,4
        }));
    }

}
