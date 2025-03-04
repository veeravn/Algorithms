package com.vnaidu;

import java.util.HashMap;



public class CopyList extends Base {

    private static class Node {
        Node next;
        int val;
        Node random;
        public Node(int val) {
            this.val = val;
        }
    }
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> oldToNew = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }
}
