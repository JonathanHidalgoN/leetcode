class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {

    int currentGasInTank = 0;
    int startingIdx = 0;
    int counter = 0;

    while (startingIdx <= gas.length - 1) {

      int safeIdx = (startingIdx + counter) % gas.length;
      currentGasInTank += gas[safeIdx] - cost[safeIdx];

      if (currentGasInTank < 0) {
        startingIdx = startingIdx + counter + 1;
        counter = 0;
        currentGasInTank = 0;
        continue;
      }

      if (counter == gas.length - 1) {
        return startingIdx;
      }

      counter++;

    }

    return -1;

  }
}
