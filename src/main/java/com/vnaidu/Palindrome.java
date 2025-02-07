package com.vnaidu;

public class Palindrome extends Base {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll(
                "[^a-zA-Z0-9]", "");
        if (s.isEmpty()) {
            return true;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.contentEquals(sb);
    }

    public static void main(String[] args) {
        logger.info(String.valueOf(isPalindrome("A man, a plan, a canal: Panama")));
    }

}
