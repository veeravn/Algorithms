package com.vnaidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstLongestConsString {


    public static String firstLongestConsecutiveSubString(String s) {
        int start;
        int counter = 0;

        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char startingChar = chars[0];
        Map<Character, Integer> charMap = new HashMap<>();
        start = 0;
        counter++;

        for(int i = 1; i < chars.length; i++ ) {
            char curChar  = chars[i];
            if(curChar != startingChar) {

                map.put(start, counter);
                if(charMap.containsKey(startingChar)) {
                    Integer previousLength = charMap.get(startingChar);
                    if(previousLength < counter) {
                        charMap.put(startingChar, start);
                    }
                } else {
                    charMap.put(startingChar, start);
                }
                counter = 1;
                start = i;

                startingChar =  curChar;
            }
            else {
                counter++;
            }
            if(i == chars.length - 1) {
                map.put(start, counter);
                if(charMap.containsKey(startingChar)) {
                    Integer previousLength = charMap.get(startingChar);
                    if(previousLength < counter) {
                        charMap.put(startingChar, start);
                    }
                } else {
                    charMap.put(startingChar, start);
                }
            }
        }

        System.out.println(map.toString());
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

    public static void main(String[] args) {
        String result = FirstLongestConsString.firstLongestConsecutiveSubString("aabbbbccddbbbb");

        System.out.println(result);
    }
}
