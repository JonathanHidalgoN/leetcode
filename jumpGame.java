class Solution {
  public boolean canJump(int[] nums) {

    int maxReacheablePositionSoFar = 0;

    for (int i = 0; i < nums.length; i++) {

      maxReacheablePositionSoFar = Math.max(maxReacheablePositionSoFar, i + nums[i]);

      if (maxReacheablePositionSoFar >= nums.length - 1) {
        return true;
      }

      if (i >= maxReacheablePositionSoFar) {
        return false;
      }

    }

    return false;

  }
}
