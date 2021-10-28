package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length > 0) {
            Map<String, List<String>> mapOfAnagrams = new HashMap<>();
            for (String string : strs) {
                char[] charArray = string.toCharArray();
                Arrays.sort(charArray);
                String sortedString = new String(charArray);
                List<String> strings = new ArrayList<>();
                strings.add(string);
                if (mapOfAnagrams.isEmpty()) {
                    mapOfAnagrams.put(sortedString, strings);
                } else {
                    if (mapOfAnagrams.get(sortedString) != null) {
                        List<String> listOfAnagrams = mapOfAnagrams.get(sortedString);
                        listOfAnagrams.add(string);
                        mapOfAnagrams.put(sortedString, listOfAnagrams);
                    } else {
                        mapOfAnagrams.put(sortedString, strings);
                    }
                }

            }

            return new ArrayList<>(mapOfAnagrams.values());
        }

        return Collections.emptyList();
    }
}
