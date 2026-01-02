class Solution {
  public int maxArea(int[] height) {

    if (height.length == 0 || height.length == 1) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;
    int gMax = 0;
    while (right > left) {
      int current = Math.abs(left - right) * Math.min(height[left], height[right]);
      gMax = Math.max(current, gMax);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return gMax;

  }
}
