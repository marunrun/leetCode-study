package main.java.leetCode;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LeetCode765 {
    public static void main(String[] args) {
//        System.out.println(minSwapsCouples(new int[]{
//                0, 2, 1, 3
//        }));
    }

    /**
     * 站起来交换座位。
     * <p>
     * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
     * <p>
     * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
     * <p>
     * 示例 1:
     * <p>
     * 输入: row = [0, 2, 1, 3]
     * 输出: 1
     * 解释: 我们只需要交换row[1]和row[2]的位置即可。
     * 示例 2:
     * <p>
     * 输入: row = [3, 2, 0, 1]
     * 输出: 0
     * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
     * 说明:
     * <p>
     * len(row) 是偶数且数值在 [4, 60]范围内。
     * 可以保证row 是序列 0...len(row)-1 的一个全排列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/couples-holding-hands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int minSwapsCouplesFirst(int[] row) {
        // 记录第一个的人的id
        int f = row[0];

        // 记录交换过的id
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < row.length; i++) {
            // 当前这个人的id
            int n = row[i];

            // 如果当前人的id已经交换过了 去找交换过的那个人的id，直到找到真实的id
            while (map.containsKey(n)) {
                n = map.get(n);
            }

            // 如果当前这个人是第二个人（即1，3，5，7，9....） 并且当前人的id与上一个人的id不可以匹配
            if (i % 2 != 0 && n != (f ^ 1)) {
                // 将上一个人对应的id 与 当前人的id互换
                map.put(f ^ 1, n);
            }

            // 记录上一个人的id
            f = n;
        }
        // 最后返回的就是交换id的次数了
        return map.size();

    }

    private static int count = 0;

    public int minSwapsCouples(int[] row) {
        int rot = row.length / 2;
        int[] fa = new int[rot];
        int[] rank = new int[rot];
        init(fa, rank, rot);
        for (int i = 0; i < row.length; i += 2) {
            merge(fa, rank, row[i] / 2, row[i + 1] / 2);
        }
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0;i<rot;i++){
        //     set.add(find(fa,i));
        // }
        return rot - count;
    }

    public void init(int[] fa, int[] rank, int n) {
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
        count = n;
    }

    public int find(int[] fa, int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa, fa[x]);
            return fa[x];
        }
    }

    public void merge(int[] fa, int[] rank, int i, int j) {
        int x = find(fa, i);
        int y = find(fa, j);
        if (x == y) {
            return;
        } else {
            count--;
        }
        if (rank[x] <= rank[y]) {
            fa[x] = y;
        } else {
            fa[y] = x;
        }
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }

}
