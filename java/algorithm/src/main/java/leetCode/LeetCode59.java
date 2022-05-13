package main.java.leetCode;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] re = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                re[top][column] = num;
                num++;
            }

            for (int row = top + 1; row <= bottom; row++) {
                re[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    re[bottom][column] = num;
                    num++;
                }

                for (int row = bottom; row > top; row--) {
                    re[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return re;
    }
}
