package com.vnaidu;

public class GCD extends Base {

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);

    }
    static int findGCD(int[] arr, int n)
    {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result;
    }
    public static void main(String[] args)
    {
        int[] arr = new int[] { 2, 4, 6, 8, 16 };
        int n = arr.length;
        logger.info(String.valueOf(findGCD(arr, n)));
    }
}
