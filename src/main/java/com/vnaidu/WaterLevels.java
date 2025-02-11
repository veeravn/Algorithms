package com.vnaidu;

public class WaterLevels extends Base {

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxWater = Math.max(maxWater, h * w);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
