package com.vnaidu;

import java.util.Arrays;

public class TwoSum extends Base {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            if (numbers[right] + numbers[left] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[right] + numbers[left] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] test1 = twoSum(new int[]{2,7,11,15}, 9);
        int[] test2 = twoSum(new int[]{2,3,4}, 6);
        int[] test3 = twoSum(new int[]{-1,0}, -1);
        int[] test4 = twoSum(new int[]{0,0,3,4}, 0);

        logger.info(Arrays.toString(test1));
        logger.info(Arrays.toString(test2));
        logger.info(Arrays.toString(test3));
        logger.info(Arrays.toString(test4));
    }
}
