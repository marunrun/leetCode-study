package main.java.leetCode;

public class LeetCode1734 {
    public static void main(String[] args) {
        decode(new int[]{
                6,5,4,6
        });
    }

    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        // 求得除了 ans[n - 1] 的所有异或结果
        int a = 0;
        for (int i = 0; i < n - 1; i += 2) a ^= encoded[i];
        // 求得 ans 的所有异或结果
        int b = 0;
        for (int i = 1; i <= n; i++) b ^= i;
        // 求得 ans[n - 1] 后，从后往前做
        ans[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;

    }
}
