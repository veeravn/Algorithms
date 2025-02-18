package com.vnaidu;

public class RansomNote extends Base {

    /**
     * Given two strings ransomNote and magazine.
     * Each letter in magazine can only be used once in ransomNote.
     * Example 1:
     * Input: ransomNote = "a", magazine = "b"
     * Output: false
     * Example 2:
     * Input: ransomNote = "aa", magazine = "ab"
     * Output: false
     * Example 3:
     * Input: ransomNote = "aa", magazine = "aab"
     * Output: true
     * @param ransomNote
     * @param magazine
     * @return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counter = new int[26];

        for (char c : magazine.toCharArray()) {
            //get the ascii value between char c and the letter a
            // increment the value at that index
            counter[c-'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (counter[c-'a'] == 0) return false;
            counter[c-'a']--;
        }
        return true;
    }
}
