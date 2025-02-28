package com.vnaidu;

import java.util.*;

class MovingAverage extends Base {
    private final int size;
    private final Queue<Double> queue;
    private final int ignore;
    private double sum;

    public MovingAverage(int k, int n) {
        this.size = k;
        this.queue = new LinkedList<>();
        this.sum = 0.0;
        this.ignore = n;
    }

    public double next(double val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;

        if (queue.size() < ignore * 2 + 1) {
            return sum / queue.size();
        }

        List<Double> sortedList = new ArrayList<>(queue);
        Collections.sort(sortedList);

        double trimmedSum = 0.0;
        for (int i = ignore; i < sortedList.size() - ignore; i++) {
            trimmedSum += sortedList.get(i);
        }

        return trimmedSum / (sortedList.size() - 2 * ignore);
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(5, 1);
        logger.info(String.valueOf(ma.next(1.0))); // 1.0
        logger.info(String.valueOf(ma.next(2.0))); // 1.5
        logger.info(String.valueOf(ma.next(100.0))); // Still includes outliers as size < k
        logger.info(String.valueOf(ma.next(3.0))); // Ignores 100.0 if k reached
        logger.info(String.valueOf(ma.next(4.0))); // Computes trimmed average ignoring top 1
        logger.info(String.valueOf(ma.next(5.0))); // Continuous trimmed averaging
    }
}
