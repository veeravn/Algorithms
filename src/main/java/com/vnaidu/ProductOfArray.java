package com.vnaidu;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductOfArray {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        IntStream.range(1, n).forEach(i -> prefix[i] = prefix[i - 1] * nums[i - 1]);
        IntStream.iterate(n - 2, i -> i >= 0, i -> i - 1)
                .forEach(i -> suffix[i] = suffix[i + 1] * nums[i + 1]);
        result = IntStream.range(0, n).map(i -> prefix[i] * suffix[i]).toArray();
        return result;
    }

    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1,2,3,4});
        StringBuilder builder = new StringBuilder("[");
        Arrays.stream(res).forEach(i -> builder.append(i).append(", "));
        int replace = builder.lastIndexOf(", ");
        builder.replace(replace, builder.length()-1, "]");
        System.out.println(builder);
    }
}
