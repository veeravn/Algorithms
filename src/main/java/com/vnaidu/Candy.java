package com.vnaidu;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Candy extends Base {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        IntStream.range(1, n)
                .filter(i -> ratings[i] > ratings[i - 1])
                .forEach(i -> candies[i] = candies[i - 1] + 1);

        IntStream.iterate(n - 2, i -> i >= 0, i -> i - 1)
                .filter(i -> ratings[i] > ratings[i + 1])
                .forEach(i -> candies[i] = Math.max(candies[i], candies[i + 1] + 1));

        return Arrays.stream(candies).sum();
    }
}
