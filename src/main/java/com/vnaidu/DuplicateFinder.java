package com.vnaidu;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder extends Base {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> dups = new HashMap<>();
        boolean result = false;
        for(int i = 0; i < nums.length; i++) {
            dups.putIfAbsent(nums[i], new ArrayList<>());
            dups.get(nums[i]).add(i);
        }
        for (List<Integer> dup : dups.values()) {
            if(dup.size() > 1) {
                int i = dup.get(0);
                int j = dup.get(dup.size()-1);
                if (Math.abs(i - j) <= k) {
                    result = true;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        String res = String.valueOf(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        logger.info(res);

    }
}
