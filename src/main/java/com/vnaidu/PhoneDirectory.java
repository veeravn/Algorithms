package com.vnaidu;

// File: PhoneDirectory.java
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PhoneDirectory extends Base {
    private final Queue<Integer> available;
    private final HashSet<Integer> used;
    private final int maxNumbers;

    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        available = new LinkedList<>();
        used = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            available.offer(i);
        }
    }

    public int get() {
        if (available.isEmpty()) return -1;
        int number = available.poll();
        used.add(number);
        return number;
    }

    public boolean check(int number) {
        return !used.contains(number) && number < maxNumbers;
    }

    public void release(int number) {
        if (used.remove(number)) {
            available.offer(number);
        }
    }
}

