package main.java.leetCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class LeetCode448 {

    public static void main(String[] args) {
        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        });
        System.out.println(disappearedNumbers);
    }
    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * <p>
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * <p>
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            int index = (num -1) % length;
            nums[index] +=  length;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                integers.add(i+1);
            }
        }
        return integers;
    }
}
