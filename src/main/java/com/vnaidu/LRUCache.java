package com.vnaidu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
//    private final int capacity;
//    private final Map<Integer, Integer> cache;

    static class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (map.size() >= capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
        map.put(key, node);
    }

    public void display() {
        Node current = head.next;
        while (current != tail) {
            System.out.print("(" + current.key + ": " + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }

//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > capacity;
//            }
//        };
//    }
//
//    public int get(int key) {
//        return cache.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        cache.put(key, value);
//    }
//
//    public void display() {
//        System.out.println(cache);
//    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);
        System.out.println(lru.get(1)); // Access key 1, should return 10
        lru.put(4, 40); // This should evict key 2 (LRU policy)
        System.out.println(lru.get(2)); // Should return -1 (not found)
        lru.display();
    }
}
