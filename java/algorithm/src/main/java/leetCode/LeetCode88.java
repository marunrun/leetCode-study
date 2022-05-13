package main.java.leetCode;

import java.util.Arrays;

public class LeetCode88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);
        System.out.println(1);
    }

    public static void main(String[] args) {
        merge(
                new int[]{
                        4, 5, 6, 0, 0, 0
                },
                3,
                new int[]{
                        1, 2, 3
                },
                3
        );
    }
}
