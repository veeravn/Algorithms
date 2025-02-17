package com.vnaidu;

import java.util.HashMap;

public class WordPattern extends Base {

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int pLen = pattern.length();

        if(words.length != pLen){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < pLen; i++){
            char currChar = pattern.charAt(i);
            String currWord = words[i];

            if(map.containsKey(currChar)){
                String corresT = map.get(currChar);
                if(!corresT.equals(currWord)){
                    return false;
                }
            }
            else if(map.containsValue(currWord)){
                return false;
            }
            else{
                map.put(currChar, currWord);
            }
        }
        return true;
    }
}
