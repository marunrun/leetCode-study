package main.java.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {

    public static void main(String[] args) {
        int[] ints = nextGreaterElements(new int[]{
                1, 2, 1
        });
        System.out.println(Arrays.toString(ints));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            res[i] = next(nums, i, length);
        }
        return res;
    }

    public static int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }

    protected static int next(int[] nums, int i, int len) {
        int res = nums[i];
        int index = (i + 1) % len;
        while (i != index) {
            if (nums[index] > res) {
                return nums[index];
            }
            index = (index + 1) % len;

        }
        return -1;
    }
}
