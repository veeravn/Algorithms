package com.vnaidu;

import java.util.stream.IntStream;

public class TriangularSum {

    /** Algorithm
     *  1. Traverse the array from i = 0 to length and replace nums[i] with nums[i] + nums[i+1]
     *  2. Deduct 1 from the length with each traversal
     *  3. Return nums[0] when length becomes 1
     */
    public static int triangularSum(int[] nums) {
        int length = nums.length;
        while(length > 1) {
            IntStream.range(0, length - 1).forEach(i -> nums[i] = (nums[i] + nums[i + 1]) % 10);
            length--;
        }
        return nums[0];
    }
}
