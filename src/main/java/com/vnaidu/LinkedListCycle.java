package com.vnaidu;
import com.vnaidu.ReverseKNodes.ListNode;

public class LinkedListCycle extends Base {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        ListNode a = head;
        ListNode b = head;

        while (b != null && b.next != null) {
            a = a.next;         // Move a pointer by 1 step
            b = b.next.next;    // Move b pointer by 2 steps

            if (a == b) {       // If they meet, there is a cycle
                return true;
            }
        }

        return false; // If b reaches the end, no cycle exists
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node3;
        logger.info(String.valueOf(hasCycle(node1)));
    }
}
