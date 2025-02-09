package com.vnaidu;

public class MinSubArrayLength extends Base{
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int currentValue = 0;
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            currentValue += nums[rightPointer];
            while (currentValue >= target) {
                result = Math.min(result, rightPointer - leftPointer + 1);
                currentValue -= nums[leftPointer++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        logger.info("" + minSubArrayLen(15, new int[] {1,1,1,1,1,1,1,1}));
    }
}
