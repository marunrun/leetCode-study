package main.java.leetCode;

public class LeetCode33 {
    /**
     * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
     * <p>
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * nums 肯定会在某个点上旋转
     * -10^4 <= target <= 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int first = nums[0];
        if (first == target) return 0;
        int last = nums[n-1];
        if (last == target) return n-1;
        boolean inTheFirst = false;
        if (first < target) {
            inTheFirst = true;
        }
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int val = nums[mid];
            if (val == target) return mid;

            // 目标在第一区间
            if (inTheFirst ) {
                // 当前在第一区间
                if (val >= first) {
                    if (val < target) {
                        low = mid+ 1;
                    } else  {
                        high = mid - 1;
                    }
                } else  {
                    if (val < target) {
                        high = mid - 1;
                    } else  {
                        low = mid+ 1;
                    }
                }
            } else  {
                // 目标在第二区间 并且当前mid也在第二区间
                if (val  <= last) {
                    if (val < target) {
                        low = mid+ 1;
                    } else  {
                        high = mid - 1;
                    }
                } else {
                    if (val < target) {
                        high = mid - 1;
                    } else  {
                        low = mid+ 1;
                    }
                }

            }
        }
        return -1;
    }


        public static void main(String[] args) {
        int search = search(new int[]{
                3,4,5,1,2
        }, 4);
        System.out.println(search);
    }
}
