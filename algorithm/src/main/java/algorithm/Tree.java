package main.java.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    /**
     * 前序遍历
     * 先打样这个节点，再打印左节点，最后打印右节点
     */
    void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    static class Node {
        int val;
        Node left;
        Node right;
    }

    /**
     * 二叉树层遍历
     */
    private List<Node> floorLevelTree(Node root) {
        List<Node> result = new ArrayList<>();
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            result.add(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 二叉查找树
     * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
     */
    public Node find(Node tree, int value) {
        Node p = tree;
        while (p != null) {
            if (value < p.val) p = p.left;
            else if (value > p.val) p = p.right;
            else return p;
        }
        return null;
    }
}
