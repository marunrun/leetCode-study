package main.java.leetCode;

public class LeetCode1720 {
    public static void main(String[] args) {
        System.out.println(decode(new int[]{6,2,7,3},4));
    }

    public static int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] decode = new int[n];
        decode[0] = first;
        for (int i = 1; i < n; i++) {
            decode[i] = decode[i-1] ^ encoded[i-1];
        }

        return decode;
    }
}
