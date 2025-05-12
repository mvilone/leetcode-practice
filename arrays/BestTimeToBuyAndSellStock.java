package arrays;
class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit that can be achieved from a single buy and sell operation
     * on a given array of stock prices, where each element represents the stock price on a specific day.
     *
     * The function assumes you must buy before you sell and returns 0 if no profit can be made.
     *
     * @param prices an array of integers where prices[i] is the stock price on the i-th day
     * @return the maximum profit possible from one transaction; 0 if no profit is possible
     */
    public int maxProfit(int[] prices) {
        // Initialize the minimum price as the price on the first day.
        // This will always represent our "buying price" to maximize future profit.
        int minPrice = prices[0];
        int maxProfit = 0;

        // Traverse through each day's price
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];

            // Update minPrice if a new lower price is found.
            // This simulates buying at the lowest price seen so far.
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }

            // Calculate the potential profit by selling at the current price
            // after buying at the lowest price seen so far.
            int potentialProfit = currentPrice - minPrice;

            // Update maxProfit if this transaction yields a better profit.
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }
        }

        // Return the best profit found.
        return maxProfit;
    }
}
