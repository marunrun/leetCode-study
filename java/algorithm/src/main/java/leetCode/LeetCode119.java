package main.java.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {
    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    /**
     * 滚动数组
     */
    public static List<Integer> getRow(int rowIndex) {
//        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j < i +1; j++) {
                if (j == 0 || j == i) {
                    integers.add(1);
                } else {
                    integers.add(pre.get( j - 1) + pre.get(j));
                }
            }
            pre = integers;
        }
        return pre;
    }
}
