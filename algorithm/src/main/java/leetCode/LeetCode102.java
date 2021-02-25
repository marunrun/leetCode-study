package main.java.leetCode;

import main.java.algorithm.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {

    /**
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层序遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            ArrayList<Integer> nums = new ArrayList<>();
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodes.poll();
                nums.add(poll.val);
                if (poll.left != null) {
                    treeNodes.add(poll.left);
                }
                if (poll.right != null){
                    treeNodes.add(poll.right);
                }
            }
            res.add(nums);
        }
        return  res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println(lists);
    }
}
