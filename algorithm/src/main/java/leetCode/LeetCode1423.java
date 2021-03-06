package main.java.leetCode;

import java.util.Arrays;

public class LeetCode1423 {
    public static void main(String[] args) {

    }

    /**
     * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
     *
     * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
     *
     * 你的点数就是你拿到手中的所有卡牌的点数之和。
     *
     * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxScore(int[] cardPoints, int k) {
        /*
         * 滑动窗口解法
         * 依次从大小为n的卡牌组的左右两边取k张卡牌，求最大值。
         * 即：剩下n-k = m张卡牌，m张卡牌为最小值。
         * 创建一个大小为m的窗口，从左往右滑动，取到最小值
         * 最终得到 卡牌总点数 - 最小值 = 最大值
         */

        int sum = 0;
        int windowSize = cardPoints.length -k;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            sum += cardPoints[i] - cardPoints[i-windowSize];
            minSum = Math.min(minSum,sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }

}
