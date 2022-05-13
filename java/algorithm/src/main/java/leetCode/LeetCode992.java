package main.java.leetCode;

public class LeetCode992 {
    public static void main(String[] args) {
        int i = subarraysWithKDistinct(new int[]{
                1, 2, 1, 2, 3
        }, 2);
        System.out.println(i);
    }

    /**
     * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
     * <p>
     * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
     * <p>
     * 返回 A 中好子数组的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int subarraysWithKDistinct(int[] A, int K) {
        return cacl(A, K) - cacl(A, K - 1);
    }

    private static int cacl(int[] A, int K) {
        int left = 0;
        int right = 0;
        int res = 0;
        int len = A.length;
        int[] sums = new int[len +1];
        int count = 0;
        while (right < len) {
            if (sums[A[right]] == 0) {
                count ++;
            }
            sums[A[right]] ++;
            right++;

            while (count > K) {
                sums[A[left]]--;
                if (sums[A[left]] == 0){
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

}
