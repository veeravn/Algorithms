package com.vnaidu;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter extends Base {
    private final Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
            hits.poll();
        }
        return hits.size();
    }
}

