package main.java.leetCode;

public class LeetCode304 {
    static class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if (n == 0) return;
            int m = matrix[0].length;
            sums = new int[n][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sums[i][j+ 1] = sums[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (; row1 <= row2; row1++) {
                sum += sums[row1][col2 + 1] - sums[row1][col1];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        });
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
