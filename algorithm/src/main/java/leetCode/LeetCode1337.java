package main.java.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LeetCode1337 {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
/*        int[][] all = new int[m][1];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++)  {
                if (mat[i][j]== 0 ) break;
                cur++;
            }
            all[i] = new int[]{cur, i};
        }
        Arrays.sort(all, (a, b)->{
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = all[i][1];
        return ans;*/

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            // 二分，找到最后一个1
            while (l < r) {
                // 算中位数
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) l = mid;
                else r = mid-1;
            }
            int cur = mat[i][r] >= 1 ? r+1:r;
            if (queue.size() == k && queue.peek()[0] > cur) queue.poll();
            if (queue.size() < k) queue.add(new int[]{cur,i});
        }
        int[] ans = new int[k];
        int idx = k  - 1;
        while (!queue.isEmpty()) ans[idx--] = queue.poll()[1];
        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]
                {
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                };

        int[] ints = kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(ints));
    }
}
