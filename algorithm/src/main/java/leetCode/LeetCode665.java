package main.java.leetCode;

public class LeetCode665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{
                3,4,2,3
        }));
//        [4,2,3]
    }

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * <p>
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean checkPossibility(int[] nums) {

        int n = nums.length, cnt = 0;

        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
