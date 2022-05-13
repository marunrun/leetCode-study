package main.java.leetCode;

public class LeetCode783 {

    static int min = Integer.MAX_VALUE;
    static int pre = -1;

    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;

        dfs(root.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 4;
        treeNode.right = new TreeNode(34);
        treeNode.right.right = new TreeNode(58);
        treeNode.right.right.left = new TreeNode(50);
        treeNode.right.right.left.right = new TreeNode(44);

        System.out.println(minDiffInBST(treeNode));
    }
}
