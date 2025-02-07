package com.vnaidu;

public class DivideTwoNumbers extends Base {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        int divis = Math.abs(divisor);
        int diff = Math.abs(dividend) - divis;
        logger.info(diff + "");
        int result = 0;
        while(diff >= 0) {
            result++;
            diff -= divis;
        }
        logger.info(result + "");
        if(dividend < 0 && divisor < 0) {

            if(Integer.MIN_VALUE == result) {
                return Integer.MAX_VALUE;
            } else {
                return result;
            }
        } else if(dividend > 0 && divisor > 0) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {

        int quo = divide(-2147483648,-1);
        logger.info(quo + "");
    }

}
