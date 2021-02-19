package main.java.leetCode;

public class LeetCode1004 {
    public static void main(String[] args) {
        int i = longestOnes(new int[]{
                0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1
        }, 3);
        System.out.println(i);
    }
    /**
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * <p>
     * 返回仅包含 1 的最长（连续）子数组的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：
     * [1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 20000
     * 0 <= K <= A.length
     * A[i] 为 0 或 1 
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int longestOnes(int[] A, int K) {
        int max = 0;
        int len = A.length;
        int changed = 0;
        int left = 0;
        int right = 0;
        while (right < len) {
            if (A[right] == 0) {
                changed++;
            }
            while (changed > K) {
                if (A[left] == 0) {
                    changed--;
                }
                left++;
            }
            right++;
            max = Math.max(max,right - left);
        }
        return max;
    }
}
