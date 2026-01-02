import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> current,
      Set<Integer> set) {

    if (current.size() == nums.length) {
      ans.add(new ArrayList<>(current));
      return;
    }

    for (int i = 0; i < nums.length; i++) {

      if (set.contains(nums[i])) {
        continue;
      }

      current.add(nums[i]);
      set.add(nums[i]);
      backtrack(nums, ans, current, set);
      current.remove(current.size() - 1);
      set.remove(nums[i]);
    }

  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, ans, new ArrayList<>(), new HashSet<>());
    return ans;
  }
}
