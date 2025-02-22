package com.vnaidu;

public class Node {

    public Node next;
    public Node random;
    public int val;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
