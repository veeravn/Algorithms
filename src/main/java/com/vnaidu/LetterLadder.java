package com.vnaidu;

import com.vnaidu.Base;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.


Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is [["hit" -> "hot" -> "dot" -> "dog" -> cog"], ["hit" -> "hot" -> "lot" -> "log" -> cog"]], which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

// Main class should be named 'Solution'
class Solution extends Base {
    
    public static int transformationLength(String begin, String end, List<String> wordList) {
        if(begin.equals(end)) {
            return 0;
        }
        if(!wordList.contains(end)) {
            return 0;
        }
        Set<String> dictionary = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        int stepCounter = 1;
        while(!queue.isEmpty()) {
            int level = queue.size();
            //new arraylist
            for(int i = 0; i < level; i++) {
                char[] letters = queue.poll().toCharArray();
                
                for(int j = 0; j < letters.length; j++) {
                    char initialChar = letters[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        letters[j] = c;
                        
                        String newWord = new String(letters);
                        if(dictionary.contains(newWord)) {
                            queue.offer(newWord);
                            dictionary.remove(newWord);
                            if(newWord.equals(end)) {
                                stepCounter++;
                                return stepCounter;
                            }
                            logger.info(newWord);
                        }
                    }
                    letters[j] = initialChar;
                }
                
            }
            stepCounter++;
        }
        return 0;
    }
    public static void main(String[] args) {
        
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        
        int length = transformationLength("hit", "cog", words); 
        
        System.out.print(length);
    }
}

