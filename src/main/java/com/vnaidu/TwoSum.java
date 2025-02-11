package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[left] + nums[right];
                if (currentSum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
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
