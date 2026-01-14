import java.util.HashMap;
import java.util.Map;

class Solution {

  private int computeChange(int[] coins, int amount, Map<Integer, Integer> memo) {

    if (amount == 0) {
      return 0;
    }

    if (amount < 0) {
      return -1;
    }

    if (memo.containsKey(amount)) {
      return memo.get(amount);
    }

    int minNumberOfCoins = 0;
    boolean foundAtLeastOneWay = false;

    for (int coin : coins) {

      int remainder = amount - coin;
      int minNumberCoinsToCreateRemainder = computeChange(coins, remainder, memo);
      if (minNumberCoinsToCreateRemainder != -1) {
        int newCandidate = minNumberCoinsToCreateRemainder + 1;
        if (!foundAtLeastOneWay) {
          minNumberOfCoins = newCandidate;
          foundAtLeastOneWay = true;
        } else if (newCandidate < minNumberOfCoins) {
          minNumberOfCoins = newCandidate;
        }
      }
    }

    int ans = foundAtLeastOneWay ? minNumberOfCoins : -1;
    memo.put(amount, ans);

    return ans;

  }

  public int coinChange(int[] coins, int amount) {
    Map<Integer, Integer> memo = new HashMap<>();
    return computeChange(coins, amount, memo);
  }

}
