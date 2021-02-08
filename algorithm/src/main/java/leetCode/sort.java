package main.java.leetCode;

import java.util.Arrays;

public class sort {

    public static void main(String[] args) {
        int[] array = {
                4, 5, 6, 1, 3, 2
        };
//        int[] ints = quickSort(array, 0, array.length - 1);
//        int[] ints = bubbleSort(array);
//        int[] ints = insertionSort(array);
        int[] tmp = new int[array.length];
        mergeSort(array,0,array.length -1,tmp);
        System.out.println(Arrays.toString(array));
    }

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
        int len = array.length;
        if (len == 1) return array;
        for (int i = 1; i < len; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[ j + 1] = array[j];
                } else {
                    break;
                }
            }

            array[ j + 1] = value;
        }

        return array;
    }

    /**
     * 快速排序
     *
     * @param array 原始数据
     * @param start 数组开始下标
     * @param end   数据结束下标
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

        for (int j = start; j < end; j++) {
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

    /**
     * 归并排序
     */
    private static void mergeSort(int[] arr,int left,int right,int[] tmp){
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr,left,mid,tmp);
            mergeSort(arr,mid+1,right,tmp);
            merge(arr,left,mid,right,tmp);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
