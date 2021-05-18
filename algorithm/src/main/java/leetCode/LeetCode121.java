package main.java.leetCode;

public class LeetCode121 {
    public static void main(String[] args) {

        System.out.print(maxProfit(new int[]{
                2,4,1
        }));
    }

    public static int maxProfit(int[] prices) {
        // 初始化
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            min = Math.min(min,price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
