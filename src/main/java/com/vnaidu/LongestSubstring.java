package com.vnaidu;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 */
public class LongestSubstring extends Base{

    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < n; rightPointer++) {
            if (!charSet.contains(s.charAt(rightPointer))) {
                charSet.add(s.charAt(rightPointer));
                maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
            } else {
                while (charSet.contains(s.charAt(rightPointer))) {
                    charSet.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
                charSet.add(s.charAt(rightPointer));
            }
        }

        return maxLength;
    }

}
