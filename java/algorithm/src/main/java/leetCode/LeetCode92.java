package main.java.leetCode;

public class LeetCode92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        // 找到前驱节点
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        // 后继节点
        for (int i = 1; i < right; i++) {
            rightNode = rightNode.next;
        }

        //截取链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
    }

    private static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = reverseBetween(listNode, 2, 4);
        System.out.println(listNode1);
    }
}
