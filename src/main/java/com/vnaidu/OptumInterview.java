package com.vnaidu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OptumInterview extends Base {

    /*
    Given an array of strings arr[] of length n, where every string representing a non-negative integers,
    the task is to arrange them in a manner such that after concatenating them in order, it results in the largest possible number.
    Since the result may be very large, return it as a string.
    Input n = 5, arr[] = {"3", "30", "34", "5", "9"}
    Output "9534330"
     */

    public static String findLargestNumber(String[] nums) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });
        
        if(nums[0].equals("0")) {
            return "0";
        }

        return String.join("", nums);
        //return Arrays.stream(nums).collect(Collectors.joining());
    }

    /*
    We are given two arrays that represent the arrival and departure times of trains, the task is to find the minimum number of platforms required so that no train waits.
Input arr[] = {900, 940, 950, 1100, 1500, 1800}, dep[] = {910, 1200, 1120, 1130, 1900, 2000}
     */
    
    public static int minNumOfPlatforms(int[] dep, int[] arr) {
        int n = dep.length;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms = 1; 
        int minPlatforms = 1;
        
        //pointers for while loop
        int i =1, j =0;
        
        while (i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }
            minPlatforms = Math.max(minPlatforms, platforms);
        }
        
        return minPlatforms;
    }
    public static void main(String[] args) {
        logger.info(findLargestNumber(new String[]{"3", "30", "34", "5", "9"}));
        
        int[] arrivals = new int[] {900, 940, 950, 1100, 1500, 1800};
        int[] departures = new int[] {910, 1120, 1130, 1200, 1900, 2000};
        logger.info(String.valueOf(minNumOfPlatforms(departures, arrivals)));
    }
}
