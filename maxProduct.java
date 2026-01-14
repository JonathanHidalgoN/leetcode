class Solution {
  public int maxProduct(int[] nums) {

    int maxVal = nums[0];
    int minVal = nums[0];
    int ans = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int currentElement = nums[i];
      int prevMax = maxVal;
      maxVal = Math.max(maxVal * currentElement, Math.max(currentElement, minVal * currentElement));
      minVal = Math.min(minVal * currentElement, Math.min(currentElement, prevMax * currentElement));
      ans = Math.max(ans, maxVal);
    }

    return ans;

  }
}
