package com.vnaidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagrams extends Base {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each word in the input array
        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(word);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main (String[] args) {
        List<List<String>> res = FindAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

        logger.info(res.toString());
    }
}
