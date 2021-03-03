package main.java.leetCode;

public class LeetCode338 {

    public int[] countBits(int num) {
        /**
         *  2
         *  0  01 10
         *  5
         *  0 01 10 11 100 110 111
         *  10
         *  0 01 10 11 100 110 111 1000 1001 1010
         */
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            res[i] = res[i >>1] + (i & 1);
        }
        return res;
    }
}
