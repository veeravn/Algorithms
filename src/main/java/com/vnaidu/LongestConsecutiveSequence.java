package com.vnaidu;

import java.util.Arrays;

public class LongestConsecutiveSequence extends Base {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        } else if(nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);

        int length = 1;
        int currentLength = 1;
        for (int i = 1; i< nums.length; i++) {
            if(nums[i] - nums[i-1] == 1)
            {
                currentLength++;
            } else if(nums[i] - nums[i-1] == 0) {
                //do nothing
            } else {
                if (currentLength > length) {
                    length = currentLength;
                }
                currentLength = 1;
            }
        }
        if (currentLength > length) {
            length = currentLength;
        }
        return length;
    }

    public static void main(String[] args) {
        logger.info(String.valueOf(longestConsecutive(new int[]{100,4,200,1,3,2})));
        logger.info(String.valueOf(longestConsecutive(new int[]{1,2,3,6,8,2,3,4,4,5,6})));
    }
}
