package main.java.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {
    public static void main(String[] args) {
        int[] ints = nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        );
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * <p>
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * <p>
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> in = new Stack<>();
        Map<Integer,Integer> biggerMap = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int value : nums2) {
            while (!in.isEmpty() && value > in.peek()) {
                biggerMap.put(in.pop(), value);
            }
            in.push(value);
        }

        while (!in.isEmpty()) {
            biggerMap.put(in.pop(),-1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = biggerMap.get(nums1[i]);
        }

        return res;
    }

}
