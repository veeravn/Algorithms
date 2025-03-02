package com.vnaidu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    // 2. LFU Cache
    private final int capacity;
    private final Map<Integer, Integer> values;
    private final Map<Integer, Integer> counts;
    private final Map<Integer, LinkedHashSet<Integer>> freqMap;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.values = new HashMap<>();
        this.counts = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.freqMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) return -1;
        updateFreq(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (values.containsKey(key)) {
            values.put(key, value);
            updateFreq(key);
            return;
        }
        if (values.size() >= capacity) {
            int toRemove = freqMap.get(minFreq).iterator().next();
            freqMap.get(minFreq).remove(toRemove);
            values.remove(toRemove);
            counts.remove(toRemove);
        }
        values.put(key, value);
        counts.put(key, 1);
        freqMap.get(1).add(key);
        minFreq = 1;
    }

    private void updateFreq(int key) {
        int freq = counts.get(key);
        counts.put(key, freq + 1);
        freqMap.get(freq).remove(key);
        if (freq == minFreq && freqMap.get(freq).isEmpty()) {
            minFreq++;
        }
        freqMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    // 4. Circular Queue
    class MyCircularQueue {
        private final int[] queue;
        private int head, tail, size;

        public MyCircularQueue(int k) {
            queue = new int[k];
            head = 0;
            tail = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % queue.length;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }
    }

}
