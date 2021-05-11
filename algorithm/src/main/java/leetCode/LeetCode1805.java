package main.java.leetCode;

public class LeetCode1805 {
    public static int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            arr[i] = i;
        }

        int count = 0;
        do {
            newArr(arr, n,perm);
            ++count;
            perm=arr.clone();
        }
        while (!check(arr,n));
        return count;
    }

    public static void newArr(int[] arr, int n,int[] perm) {
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                arr[i] = perm[i/2];
            } else  {
                arr[i] = perm[n /2 + (i-1) /2];
            }
        }
    }

    public static  boolean check(int[] arr,int n){
        for (int i = 0; i < n; i++) {
            if (i != arr[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(reinitializePermutation(4));
    }

}
