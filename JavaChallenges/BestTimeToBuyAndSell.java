// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price to a large value
        int maxProfit = 0; // Initialize the maximum profit to zero

        for (int price : prices) {
            // Update the minimum price if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // Update the maximum profit if the current profit is higher
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}