package main.java.leetCode;

public class LeetCode190 {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        int i = reverseBits(111);
        System.out.println(i);
    }
}
