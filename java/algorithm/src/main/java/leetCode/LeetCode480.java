package main.java.leetCode;

import java.util.*;

public class LeetCode480 {

    public static void main(String[] args) {
        int[] ints = {
                2147483647,2147483647
        };
        double[] doubles = medianSlidingWindow(ints, 2);
        System.out.println(doubles);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }

        double[] ans = new double[nums.length -k +1];
        ans[0] = dualHeap.getMid();

        for (int i = k; i < nums.length; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.erase(nums[i -k]);
            ans[i -k + 1] = dualHeap.getMid();
        }
        return ans;
    }

    static class DualHeap {

        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;

        // 哈希表，key为元素，value为需要删除的次数
        private Map<Integer, Integer> delayed;

        private int k;

        // small 和 large 当前包含的元素个数，需要扣除被「延迟删除」的元素
        private int smallSize, largeSize;

        public DualHeap(int k) {
            this.large = new PriorityQueue<>(Integer::compareTo);
            this.small = new PriorityQueue<>(Comparator.reverseOrder());
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        public double getMid() {
            return (k & 1) == 1 ? small.peek() : (((double)small.peek() + (double)large.peek()) * 0.5) ;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                ++smallSize;
            } else {
                large.offer(num);
                ++largeSize;
            }
            makeBalance();
        }

        public void erase(int num){
            delayed.put(num,delayed.getOrDefault(num,0) +1);
            if (num <= small.peek()){
                --smallSize;
                if (num == small.peek()){
                    prune(small);
                }
            } else {
                --largeSize;
                if (num == large.peek()){
                    prune(large);
                }
            }
            makeBalance();
        }

        private void makeBalance() {
            //
            if (smallSize > largeSize +1){
               large.offer(small.poll());
               --smallSize;
               ++largeSize;
               prune(small);
            } else if(smallSize < largeSize){
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                prune(large);
            }
        }

        // 不断地弹出 heap 的堆顶元素，并且更新哈希表
        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }
    }

}
