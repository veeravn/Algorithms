package com.vnaidu;

public class RemoveNode extends Base {

    public static ListNode removeNthNode(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = new ListNode.NodeBuilder()
                .setNext(head)
                .setVal(0)
                .build();
        ListNode curr = newNode;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int duplicate = curr.next.val;
                while (curr.next != null && curr.next.val == duplicate)
                    curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return newNode.next;
    }
}
