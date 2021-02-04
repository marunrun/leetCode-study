package main.java.leetCode;

import java.util.Arrays;

public class LeetCode888 {
    public static void main(String[] args) {
        int[] ints = {1, 1};
        int[] ints2 = {2, 2};
        int[] ans = fairCandySwap(ints, ints2);
        System.out.println(Arrays.toString(ans));
    }


    public static int[] fairCandySwap(int[] A, int[] B) {
        int Asum = Arrays.stream(A).sum();
        int Bsum = Arrays.stream(B).sum();
        int[] ans = new int[2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (Asum - A[i] + B[j] == Bsum - B[j] + A[i]) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    return ans;
                }
            }
        }
        return ans;
    }
}
