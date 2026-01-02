import java.util.ArrayList;
import java.util.List;

class Solution {

  private void backtrack(int[] nums, List<List<Integer>> ans, int index, List<Integer> current) {

    ans.add(new ArrayList<>(current));

    for (int i = index; i < nums.length; i++) {
      current.add(nums[i]);
      backtrack(nums, ans, i + 1, current);
      current.remove(current.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, ans, 0, new ArrayList<Integer>());
    return ans;
  }
}
