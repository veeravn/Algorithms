package com.vnaidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstLongestConsString {


    public static String firstLongestConsecutiveSubString(String s) {
        int start, counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Character, Integer> charMap = new HashMap<>();

        char[] chars = s.toCharArray();
        char startingChar = chars[0];
        start = 0;
        counter++;

        for(int i = 1; i < chars.length; i++ ) {
            char curChar  = chars[i];
            if(curChar != startingChar) {
                doComparison(start, counter, map, startingChar, charMap);
                counter = 1;
                start = i;
                startingChar =  curChar;
            }
            else {
                counter++;
            }
            if(i == chars.length - 1) {
                doComparison(start, counter, map, startingChar, charMap);
            }
        }

        int longest = 0, first = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entries) {
            int curLength = entry.getValue();
            if(longest < curLength) {
                longest = curLength;
                first = entry.getKey();
            }
        }
        return first + ", " + longest;
    }

    private static void doComparison(int start, int counter, Map<Integer, Integer> map, char startingChar, Map<Character, Integer> charMap) {
        map.put(start, counter);
        if (charMap.containsKey(startingChar)) {
            Integer previousLength = charMap.get(startingChar);
            if (previousLength < counter) {
                charMap.put(startingChar, start);
            }
        } else {
            charMap.put(startingChar, start);
        }
    }

    public static void main(String[] args) {
        String result = FirstLongestConsString.firstLongestConsecutiveSubString("aabbbbccddbbbb");

        System.out.println(result);
    }
}
