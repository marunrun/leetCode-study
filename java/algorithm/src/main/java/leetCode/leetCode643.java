package main.java.leetCode;

public class leetCode643 {
    public static void main(String[] args) {
        double maxAverage = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        System.out.println(maxAverage);
    }

    public static double findMaxAverage(int[] nums, int k) {

        double max;
        double sum = 0.0;

        int[] windows = new int[k];

        for (int i = 0; i < k; i++) {
            sum  += nums[i];
            windows[i] = nums[i];
        }
        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum -= windows[i%k];
            sum += nums[i];
            windows[i%k] = nums[i];
            max = Math.max(sum,max);
        }

        return max / k;
    }


}
