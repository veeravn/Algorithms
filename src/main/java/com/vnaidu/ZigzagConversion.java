package com.vnaidu;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        char[] sArray = s.toCharArray();
        //for each row
        for (int i = 0; i < numRows; i++) {
            //start at the ith position in the string
            for (int j = i; j < s.length(); j += (2 * (numRows - 1))) {
                builder.append(sArray[j]);
                int i1 = j + (2 * (numRows - 1)) - (2 * i);
                if (i > 0 && i < numRows - 1 && i1 < s.length()) {
                    builder.append(sArray[i1]);
                }
            }
        }
        return builder.toString();
    }

    public static void main (String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
