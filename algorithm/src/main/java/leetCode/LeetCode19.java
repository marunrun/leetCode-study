package main.java.leetCode;


import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LeetCode19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        removeNthFromEnd(listNode, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;
        head = new ListNode(0, head);
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode removedNode = list.get(list.size() - n);
        ListNode listNode = list.get(list.size() - n - 1);
        listNode.next = removedNode.next;
        return list.get(0).next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


}
