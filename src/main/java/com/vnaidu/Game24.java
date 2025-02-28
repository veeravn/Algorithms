package com.vnaidu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Game24 extends Base {
    private static final double EPSILON = 1e-6;

    public static boolean canReach24(int[] nums) {
        List<Double> list = Arrays.stream(nums)
                .mapToDouble(num -> (double) num)
                .boxed()
                .collect(Collectors.toList());
        return solve(list);
    }

    private static boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < EPSILON;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                final int fi = i, fj = j;
                List<Double> nextNums = IntStream.range(0, nums.size())
                        .filter(k -> k != fi && k != fj)
                        .mapToObj(nums::get)
                        .collect(Collectors.toList());

                double a = nums.get(i), b = nums.get(j);
                List<Double> operations = Arrays.asList(a + b, a - b, b - a, a * b);

                for (double val : operations) {
                    nextNums.add(val);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }

                if (Math.abs(b) > EPSILON) {
                    nextNums.add(a / b);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }
                if (Math.abs(a) > EPSILON) {
                    nextNums.add(b / a);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        logger.info(String.valueOf(canReach24(new int[]{8, 8, 3, 3}))); // true
        logger.info(String.valueOf(canReach24(new int[]{1, 1, 1, 1}))); // false
    }
}

