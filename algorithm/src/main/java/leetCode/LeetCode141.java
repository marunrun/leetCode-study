package main.java.leetCode;


import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode141 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        hasCycle(listNode);
        hasCycle2(listNode);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针 空间O(1) 时间(On)
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
