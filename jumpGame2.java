class Solution {
  public int jump(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    int maxReachIdx = 0;
    int maxPaidIdx = 0;
    int idx = 0;
    int nJumps = 0;

    while (maxPaidIdx < nums.length - 1) {

      maxReachIdx = Math.max(maxReachIdx, nums[idx] + idx);

      if (maxPaidIdx == idx) {
        nJumps++;
        maxPaidIdx = maxReachIdx;
      }

      idx++;

    }

    return nJumps;
  }
}
