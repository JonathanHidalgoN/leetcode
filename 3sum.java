import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int total = nums[i] + nums[left] + nums[right];
        if (total == 0) {
          ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }
        } else if (total > 0) {
          right--;
        } else {
          left++;
        }
      }

    }

    return ans;

  }
}
