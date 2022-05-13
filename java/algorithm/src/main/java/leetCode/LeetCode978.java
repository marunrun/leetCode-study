package main.java.leetCode;

public class LeetCode978 {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{
                9,9
                // > > < > < == > <
        }));
    }

    /**
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     * <p>
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     * <p>
     * 返回 A 的最大湍流子数组的长度。
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len < 2) return len;

        char ope = 0;

        int left = 0;
        int right = 1;
        int max = 1;

        while (right < len) {
            if (arr[right - 1] > arr[right]) {
                if (right > 1 && ope != '<') {
                    left = right-1;
                }
                ope = '>';
            } else if (arr[right - 1] < arr[right]) {
                if (right > 1 && ope != '>') {
                    left = right-1;
                }
                ope = '<';
            } else {
                ope = '=';
                left = right;
            }
            right++;
            max = Math.max(max,right - left);
        }

        return max;
    }
}
