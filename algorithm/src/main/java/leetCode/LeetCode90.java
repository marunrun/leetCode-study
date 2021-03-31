package main.java.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode90 {
     List<Integer> tmp = new ArrayList<>();
     List<List<Integer>> res = new ArrayList<>();
     HashMap<String,Integer> map = new HashMap<>();

    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            tmp.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    tmp.add(nums[i]);
                }
            }
            tmp.sort(Integer::compareTo);
            StringBuilder str = new StringBuilder();
            for (int i : tmp) {
                str.append(i);
            }
            if (!map.containsKey(str.toString())) {
                map.put(str.toString(), 1);
                res.add(new ArrayList<>(tmp));
            }
        }
        return res;
    }


}
