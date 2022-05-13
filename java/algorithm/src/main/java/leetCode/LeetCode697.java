package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode697 {

    public static void main(String[] args) {
        int shortestSubArray = findShortestSubArray(new int[]{
                1,2
        });
        System.out.println(shortestSubArray);
    }

    /**
     * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
     * <p>
     * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1, 2, 2, 3, 1]
     * 输出：2
     * 解释：
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * 示例 2：
     * <p>
     * 输入：[1,2,2,3,1,4,2]
     * 输出：6
     *  
     * <p>
     * 提示：
     * <p>
     * nums.length 在1到 50,000 区间范围内。
     * nums[i] 是一个在 0 到 49,999 范围内的整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/degree-of-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int findShortestSubArray(int[] nums) {
        if (nums.length == 1) return 1;
        Map<Integer, Integer> maps = new HashMap<>();
        int du = 0;
        for (int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
            du = Math.max(du, maps.get(num));
        }
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (maps.get(num) != du) continue;
            times.put(num, times.getOrDefault(num, 0) + 1);
            if (!first.containsKey(num)) {
                first.put(num, i);
                continue;
            }

            if (times.get(num) == du) {
                min = Math.min(min, i - first.get(num) + 1);
            }
        }

        return min == Integer.MAX_VALUE ? 1: min;
    }
}
