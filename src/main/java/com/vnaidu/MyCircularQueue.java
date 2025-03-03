package com.vnaidu;

public class MyCircularQueue extends Base {
    private final int[] queue;
    private int head, tail, size, capacity;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        head = tail = size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

