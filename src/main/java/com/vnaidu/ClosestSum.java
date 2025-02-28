package com.vnaidu;

// Find and return a pair of integers in a sorted array (all integers are positive) that, when summed up, bring you the closest to the value of k.
// Example Input:[5, 8, 14, 17, 25, 40, 43] k: 35
// Expected Output: (8, 25) since 8 + 25 = 33 which is closest to 35 (sum could be equals to, smaller or larger than k)

import java.util.Arrays;

public class ClosestSum extends Base{

    public static int[] findClosestPair(int[] arr, int k) {
        int left = 0; int right = arr.length -1;
        int currentSum = 0, closestSum = 0;
        int [] bestPair = new int[2];

        if (arr.length == 2) {
            return arr;
        }

        while (left < right) {
            currentSum = arr[left] + arr[right];

            if(Math.abs(k - currentSum) < Math.abs(k - closestSum)) {
                closestSum = currentSum;
                bestPair[0] = arr[left];
                bestPair[1] = arr[right];
            }

            if (currentSum < k ) {
                left++;
            } else {
                right--;
            }
        }
        return bestPair;
    }
    public static void main(String[] args) {
        logger.info(Arrays.toString(ClosestSum.findClosestPair(new int[] {5, 8, 14, 17, 25, 40, 43}, 35)));
    }
}
