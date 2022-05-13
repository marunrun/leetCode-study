package main.java.leetCode;


public class LeetCode1208 {
    public static void main(String[] args) {

        int i = equalSubstring(
                "abcd",
                "cdef",
                1
        );
        System.out.println(i);
    }

    /**
     * 窗口滑动解法，找到连续的且总开销不大于指定最大开销的字符串
     *
     * 给你两个长度相同的字符串，s 和 t。
     *
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     *
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     *
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     *
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int len = sChars.length;

        // 当前
        int cost = 0;

        int left = 0;
        int right = 0;

        while (right < len) {
            // 开销绝对值
            int abs = Math.abs(sChars[right] - tChars[right]);
            cost += abs;

            // 如果当前开销大于最大开销 窗口向右滑动
            if (cost > maxCost) {
                cost -= Math.abs(sChars[left] - tChars[left]);
                left++;
            }

            ++right;
        }

        return right-left;
    }
}
