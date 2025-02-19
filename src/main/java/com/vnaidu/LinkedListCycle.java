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

}
