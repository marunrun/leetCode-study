package main.java.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

    void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    static class Node {
        String val;
        Node left;
        Node right;
    }

    private List<Node> floorLevelTree(Node root){
        List<Node> result = new ArrayList<>();
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            result.add(node);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return result;
    }
}
