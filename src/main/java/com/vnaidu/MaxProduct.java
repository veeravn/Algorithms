package com.vnaidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProduct extends Base {
    public static int maxProd(int[] nums) {
        int maxProduct = 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for(int i = 0; i <= nums.length-1; i++) {
            if(nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
;           }
            if(nums[i] < min2 && nums[i] != min1) {
                min2 = nums[i];
            }
            if(nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            }
            if(nums[i] > max2 && nums[i] != max1) {
                max2 = nums[i];
            }
            logger.info("\nmin1: " + min1 + "\nmax1: " + max1 + "\nmin2: " + min2 + "\nmax2: " + max2);
//            for(int j = 0; j < nums.length -1; j++) {
//                if(i != j) {
//                    maxProduct = Math.max(maxProduct, nums[i] * nums[j]);
//                }
//            }
        }
        //return maxProduct;
        return Integer.max(max1*max2, min1*min2);
    }

    public static void main(String [] args) {
        //logger.info(String.valueOf(maxProd(new int[] {1,2,5,4,3})));
        //logger.info(String.valueOf(maxProd(new int[] {1,2,-5,-3,2,1})));
        logger.info(String.valueOf(maxProd(new int[] {-3,6,-4,2,5})));
    }

}
