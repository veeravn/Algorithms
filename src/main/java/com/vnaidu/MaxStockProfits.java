package com.vnaidu;

public class MaxStockProfits {

    public static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit,prices[i]-lowest);
            lowest = Math.min(prices[i],lowest);
        }
        return profit;
    }

    public static void main (String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
