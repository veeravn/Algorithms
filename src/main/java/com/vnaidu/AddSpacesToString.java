package com.vnaidu;



public class AddSpacesToString extends Base {

    public static String addSpaces(String s, int[] spaces) {
        char[] res = new char[s.length()+spaces.length];
        int i = 0, j = 0, k = 0;

        while (i < s.length()) {
            if (j < spaces.length && i == spaces[j]) {
                res[k++] = ' ';
                j++;
            }
            res[k++] = s.charAt(i++);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        logger.info(AddSpacesToString.addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
    }

}
