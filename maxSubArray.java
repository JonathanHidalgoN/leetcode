class Solution {
  public int maxSubArray(int[] nums) {

    int left = 0;
    int currentSum = nums[0];
    int maxSumSoFar = nums[0];

    for (int right = 1; right < nums.length; right++) {

      while (currentSum <= 0 && left < right) {
        currentSum -= nums[left];
        left++;
      }

      currentSum += nums[right];
      maxSumSoFar = Math.max(maxSumSoFar, currentSum);

    }

    return maxSumSoFar;
  }
}
