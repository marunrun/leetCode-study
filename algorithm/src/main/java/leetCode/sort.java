package main.java.leetCode;

import java.util.Arrays;

public class sort {

    /**
     * 冒泡排序
     *
     * @param array 原始数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array) {
        int count = array.length;
        if (count < 1) return array;

        for (int i = 0; i < count; i++) {
            boolean flag = false;
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }

                // 如果已经没有需要的排序的数据 直接跳出循环
                if (!flag) break;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array 原始数组
     * @return 排序后的数组
     */
    public static int[] insertionSort(int[] array) {
        int count = array.length;
        if (count < 1) return array;
        for (int i = 1; i < count; i++) {
            int value = array[i];
            int j = i - 1;

            for (; j >= 0; --j) {
                // 依次比较
                if (array[j] > value) {
                    // 数据搬移
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }
        return array;
    }

    /**
     * 快速排序
     * @param array 原始数据
     * @param start 数组开始下标
     * @param end 数据结束下标
     * @return 处理后的数据
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) return array;
        int q = partition(array, start, end);
        quickSort(array, start, q - 1);
        quickSort(array, q + 1, end);
        return array;
    }

    protected static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;

        for (int j = start; j < end ; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);

        return i;
    }

    protected static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] ints = quickSort(array, 0, array.length - 1);
//        int[] ints = bubbleSort(array);
//        int[] ints = insertionSort(array);
        System.out.println(Arrays.toString(ints));
    }
}
