class Solution {

  public static void main(String[] args) {
    System.out.println("Hello, running program main");
    int[] prices = new int[] { 1, 2, 3, 4, 5, 1, 10 };
    int maxProfit = maxProfit(prices);
    System.out.println("The max profit is: " + maxProfit);
  }

  public static int maxProfit(int[] prices) {

    int maxProfitSoFar = 0;
    int minPriceSoFar = prices[0];

    for (int i = 1; i < prices.length; i++) {
      int currentPrice = prices[i];

      if (currentPrice < minPriceSoFar) {
        minPriceSoFar = currentPrice;
      } else {
        maxProfitSoFar = Math.max(maxProfitSoFar, currentPrice - minPriceSoFar);
      }
    }

    return maxProfitSoFar;

  }
}
