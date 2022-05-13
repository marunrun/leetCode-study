package main.java.leetCode;


import java.util.PriorityQueue;

public class LeetCode703 {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
// [[1,[]],[-3],[-2],[-4],[0],[4]]
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     * 用优先队列保存前 k 个数，队头的就是第k大的数
     */
     static class KthLargest {
        PriorityQueue<Integer> items;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            items = new PriorityQueue<>();
            for (int val: nums) {
                items.offer(val);
                if (items.size()  > k) {
                    items.poll();
                }
            }
        }

        public int add(int val) {
            items.offer(val);
            if (items.size() > k) {
                items.poll();
            }
            return items.peek();
        }
    }


}
