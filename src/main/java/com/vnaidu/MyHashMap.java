package com.vnaidu;

public class MyHashMap {
    private static final int SIZE = 10000;
    private final Node[] nodes;

    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
        } else {
            Node prev = find(nodes[index], key);
            if (prev.next == null) {
                prev.next = new Node(key, value);
            } else {
                prev.next.value = value;
            }
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (nodes[index] == null) return -1;
        Node node = find(nodes[index], key);
        return node.next == null ? -1 : node.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (nodes[index] == null) return;
        Node prev = find(nodes[index], key);
        if (prev.next != null) prev.next = prev.next.next;
    }

    private Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
