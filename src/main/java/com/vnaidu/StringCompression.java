package com.vnaidu;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression extends Base {

    public static String compressString(String str, int chunkSize) {
        if (str == null || str.length() < chunkSize) {
            return str; // Return original if too short
        }

        Map<String, Character> dictionary = new LinkedHashMap<>();
        char label = 'A';

        for (int i = 0; i <= str.length() - chunkSize; i++) {
            String chunk = str.substring(i, i + chunkSize);

            if (!dictionary.containsKey(chunk)) {
                dictionary.put(chunk, label++);
            }
        }

        // Replace substrings with corresponding labels
        String compressedString = str;
        for (Map.Entry<String, Character> entry : dictionary.entrySet()) {
            System.out.println("currentString: " + compressedString + ", key: " + entry.getKey() + ", value: " + entry.getValue());
            compressedString = compressedString.replace(entry.getKey(), String.valueOf(entry.getValue()));
        }

        return compressedString;
    }

    public static void main(String[] args) {
        String input = "abcdefghijabcdefghijabcde";
        int chunkSize = 5;

        String compressed = compressString(input, chunkSize);
        logger.info("Original: " + input);
        logger.info("Compressed: " + compressed);
    }
}
