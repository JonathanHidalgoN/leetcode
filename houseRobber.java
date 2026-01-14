class Solution {
  public int rob(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int twoHousesAgo = nums[0];
    int lastHouse = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      int tmp = lastHouse;
      lastHouse = Math.max(lastHouse, nums[i] + twoHousesAgo);
      twoHousesAgo = tmp;
    }

    return lastHouse;

  }
}
