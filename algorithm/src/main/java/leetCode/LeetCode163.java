package main.java.leetCode;

public class LeetCode163 {

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        double res = n;
        while (res > 5 && res % 1 == 0) {
            double tmp = res / 2;

            if (tmp % 1 != 0) {
                tmp = res / 3;
            }

            if (tmp % 1 != 0) {
                tmp = res / 5;
            }
            res = tmp;
        }
        return res % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }
}
