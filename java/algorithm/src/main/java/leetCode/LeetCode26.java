package main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

//
//        Map<Integer, Integer> map = new HashMap<>();
//        int cur = 0;
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//                nums[cur] = num;
//                cur++;
//            }
//        }
//        return cur;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{
                0,0,1,1,1,2,2,3,3,4
        }));
    }
}
