import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> current, int currentIndex) {

    if (currentIndex == nums.length) {
      ans.add(new ArrayList<>(current));
      return;
    }

    current.add(nums[currentIndex]);
    backtrack(nums, ans, current, currentIndex + 1);
    current.remove(current.size() - 1);

    int newIdx = currentIndex + 1;
    while (newIdx <= nums.length - 1 && nums[currentIndex] == nums[newIdx]) {
      newIdx++;
    }

    backtrack(nums, ans, current, newIdx);

  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, ans, new ArrayList<Integer>(), 0);
    return ans;
  }
}
