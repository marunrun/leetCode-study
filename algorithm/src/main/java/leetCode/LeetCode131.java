package main.java.leetCode;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode131 {
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * <p>
     * 回文串 是正着读和反着读都一样的字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len = s.length();
        List<String> sub = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            sub.add(String.valueOf(s.charAt(i)));

        }
        res.add(sub);

        while (len > 1) {


        }


        for (int i = len - 1; i > 1; i--) {
            sub = new ArrayList<>();

        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
