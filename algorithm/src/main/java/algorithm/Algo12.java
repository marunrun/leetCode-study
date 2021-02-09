package main.java.algorithm;

import java.util.Arrays;

public class Algo12 {
    public static void main(String[] args) {
        int[] ints = {
                6,1,3,5,7,2,4,9,11,8
        };

        int max = getMax(ints, 8, 0, ints.length - 1);

        System.out.println(max);
    }

    /**
     * 求无序数组中的第 K 大元素
     */
    public static int getMax(int[] arr, int k, int start, int end) {
        if (end <= start) return arr[k-1];
        int q = partition(arr, start, end);
        if (q + 1 == k) {
            return arr[q];
        }

        if (q + 1 > k) {
            getMax(arr, k, start, q - 1);
        }
        if (q + 1 < k) {
            getMax(arr, k, q + 1, end);
        }

        return arr[k-1];
    }

    public static int partition(int[] arr,int start,int end){
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] > pivot) {
                sort.swap(arr,j,i);
                i++;
            }
        }
        sort.swap(arr,i,end);
        return i;
    }
}
