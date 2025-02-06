package com.vnaidu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubstringConcatenation {
    public static List<Integer> findSubstring(String s, String[] words) {
        int N = s.length();
        int M = words.length == 0 ? 0 : words[0].length();
        int wordCount = words.length;
        int totalLength = M * wordCount;

        if (words.length == 0 || N < totalLength) {
            return Collections.emptyList();
        }

        // Compute word frequencies using streams
        Map<String, Long> wordFreq = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        return IntStream.range(0, M)  // Iterate over possible starting indices
                .mapToObj(i -> findSubstringAtIndex(s, wordFreq, i, M, wordCount, N))
                .flatMap(List::stream)  // Flatten results
                .toList();  // Collect into a list
    }

    private static List<Integer> findSubstringAtIndex(String s, Map<String, Long> wordFreq, int start, int wordLength, int wordCount, int N) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Long> currentWindow = new HashMap<>();
        int left = start, right = start, count = 0;

        while (right + wordLength <= N) {
            String word = s.substring(right, right + wordLength);
            right += wordLength;

            if (wordFreq.containsKey(word)) {
                currentWindow.merge(word, 1L, Long::sum);
                count++;

                while (currentWindow.get(word) > wordFreq.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    currentWindow.computeIfPresent(leftWord, (k, v) -> v > 1 ? v - 1 : null);
                    count--;
                    left += wordLength;
                }

                if (count == wordCount) {
                    indexes.add(left);
                }
            } else {
                currentWindow.clear();
                count = 0;
                left = right;
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words)); // Output: [0, 9]
    }
}
