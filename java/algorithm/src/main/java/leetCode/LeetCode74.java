package main.java.leetCode;

public class LeetCode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
//                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
                {1}
        }, 0));
    }
}
