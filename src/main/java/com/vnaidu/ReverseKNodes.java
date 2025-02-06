package com.vnaidu;


public class ReverseKNodes {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes left
        ListNode temp = head;
        int count = 0;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        // If we have at least k nodes, reverse them
        if (count == k) {
            ListNode prev = null, curr = head, next = null;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Recursively reverse the remaining part
            head.next = reverseKGroup(curr, k);

            return prev; // `prev` is the new head of this k-group
        }

        // If there are fewer than k nodes left, return head as it is
        return head;
    }

    public static void main (String[] args)
    {
    }
}

