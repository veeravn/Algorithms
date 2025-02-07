package com.vnaidu;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinarySearch extends Base {

    public static void main(String[] args) {
        checkAnswer(1, new int[] {1}, true);
        checkAnswer(2, new int[] {1}, false);
        int[] array2 = new int[100];

        // test case 2: value located in first half of the array
        // test case 3: value located in second half of the array
        // test case 4: value located in middle of the array
        // test case 5: value located at the end of the array
        // test case 6: value located at the beginning of the array
    }

    public static void checkAnswer(int value, int[] array, boolean expected) {
        final boolean actual = arrayContains(value, array);
        final String status = (actual == expected) ? "ok" : "ERROR";
        final String arrayStr = array == null ? "null" : Arrays.stream(array).boxed().collect(Collectors.toList()).toString();
        logger.info(status + ": looking for " + value + " in " + arrayStr + "    expected=" + expected + " actual=" + actual);
    }

    /**
     * Returns true iff the value is present in the array.
     *
     * Runs in O(log(n)) time in the size of the array.
     *
     * @param value The value to look for in the array.
     * @param array An array of numbers, which is guaranteed to be sorted
     *              from smallest to largest.
     * @return True if the value is present, false if not.
     */
    public static boolean arrayContains(int value, int[] array) {
        // This implementation returns the correct answer, but does
        // not meet the requirement of running in O(log(n)) time.

        //check if last element is greater than value, if not then return false


        int leftMost = 0;
        int rightMost = array.length-1;
        int mid = 0;


        while (leftMost<=rightMost) {
            mid = leftMost + (rightMost - leftMost)/2;
            if (array[mid] == value) return true;
            else if(array[mid] < value) leftMost = mid +1;
            else rightMost = mid - 1;
        }

        return false;



        // for (int v : array) {
        //     if (v == value) {
        //         return true;
        //     }
        // }
        // return false;
    }

}
