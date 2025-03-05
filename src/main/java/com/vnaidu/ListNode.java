package com.vnaidu;

public class ListNode {

    public ListNode next;
    public ListNode random;
    public int val;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    private ListNode(NodeBuilder builder) {
        this.val = builder.val;
        this.next = builder.next;
        this.random = builder.random;
    }

    public static class NodeBuilder {
        private ListNode next;
        private ListNode random;
        private int val;

        public NodeBuilder setNext(ListNode next) {
            this.next = next;
            return this;
        }

        public NodeBuilder setRandom(ListNode random) {
            this.random = random;
            return this;
        }

        public NodeBuilder setVal(int val) {
            this.val = val;
            return this;
        }

        public ListNode build() {
            return new ListNode(this);
        }
    }
}
