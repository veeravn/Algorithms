package com.vnaidu;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicatePairs {

    public static List<List<Integer>> findDuplicatePairs(List<List<Integer>> pairs) {
        // Use a map to count occurrences of each normalized pair
        Map<List<Integer>, Long> pairCounts = pairs.stream()
                // Normalize pairs by sorting
                .map(pair -> pair.stream().sorted().collect(Collectors.toList()))
                // Count occurrences using a Map
                .collect(Collectors.groupingBy(pair -> pair, Collectors.counting()));

        // Extract pairs that appear more than once
        return pairCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> pairs1 = Arrays.asList(
                Arrays.asList(3, 2), Arrays.asList(3, 2),
                Arrays.asList(1, 2), Arrays.asList(2, 1)
        );
        List<List<Integer>> pairs2 = Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(3, 1), Arrays.asList(3, 3)
        );
        List<List<Integer>> pairs3 = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(3, 4)
        );

        System.out.println(findDuplicatePairs(pairs1)); // Output: [[2, 3], [1, 2]]
        System.out.println(findDuplicatePairs(pairs2)); // Output: [[1, 3]]
        System.out.println(findDuplicatePairs(pairs3)); // Output: []
    }
}
