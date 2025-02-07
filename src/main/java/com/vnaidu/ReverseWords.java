package com.vnaidu;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {

    public static String reverseWords(String s) {
        String trimmed = s.trim();
        String[] words = trimmed.split(" ");
        List<String> reverseWords = Arrays.asList(words);
        Collections.reverse(reverseWords);
        String sb = reverseWords.stream()
                .filter(word -> !word.isEmpty())
                .map(word -> new StringBuilder(word) + " ")
                .collect(Collectors.joining());
        return sb.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
