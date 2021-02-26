package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static List<Integer> tmp = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();


    public static List<List<Integer>> subsets(int[] nums) {
//        dfs(0, nums);
//        return res;

        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            tmp.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        dfs(cur + 1, nums);
        tmp.remove(tmp.size() - 1);
        dfs(cur + 1, nums);
    }



    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{
                1, 2, 3
        });
        System.out.println(subsets);
    }
}
