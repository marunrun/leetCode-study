package main.java.leetCode;

public class LeetCode191 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        int i = hammingWeight(00000000000000000000000010000000);
        System.out.println(i);

    }
}
