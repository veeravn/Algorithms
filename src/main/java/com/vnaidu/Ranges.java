package com.vnaidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ranges extends Base {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) start = nums[i];
            }
        }
        return result;
    }

    public static List<double[]> rangeDifference(List<double[]> a, List<double[]> b) {
        List<double[]> result = new ArrayList<>();

        for (double[] aRange : a) {
            List<double[]> temp = new ArrayList<>();
            temp.add(aRange);

            for (double[] bRange : b) {
                List<double[]> newTemp = new ArrayList<>();
                for (double[] range : temp) {
                    double start = range[0], end = range[1];
                    double bStart = bRange[0], bEnd = bRange[1];

                    if (bEnd <= start || bStart >= end) {
                        // No overlap
                        newTemp.add(new double[]{start, end});
                    } else {
                        // Overlapping cases
                        if (start < bStart) {
                            newTemp.add(new double[]{start, bStart});
                        }
                        if (end > bEnd) {
                            newTemp.add(new double[]{bEnd, end});
                        }
                    }
                }
                temp = newTemp;
            }
            result.addAll(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<double[]> a1 = Arrays.asList(new double[]{2.5, 7.5});
        List<double[]> b1 = Arrays.asList(new double[]{4.3, 9.3});
        System.out.println(rangeDifference(a1, b1)); // [(2.5, 4.3)]

        List<double[]> a2 = Arrays.asList(new double[]{2.5, 7.5}, new double[]{9.0, 10.4});
        List<double[]> b2 = Arrays.asList(new double[]{4.3, 9.3}, new double[]{9.5, 11.0});
        System.out.println(rangeDifference(a2, b2)); // [(2.5, 4.3), (9.3, 9.5)]

        List<double[]> a3 = Arrays.asList(new double[]{2.5, 7.5}, new double[]{9.0, 10.4});
        List<double[]> b3 = Arrays.asList(new double[]{9.3, 9.7});
        System.out.println(rangeDifference(a3, b3)); // [(2.5, 7.5), (9.0, 9.3), (9.7, 10.4)]
    }
}
