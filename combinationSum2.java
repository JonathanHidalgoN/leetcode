import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  private void backtrack(int[] candidates, int remaining, int idx, List<Integer> current, List<List<Integer>> ans) {

    if (remaining == 0) {
      ans.add(new ArrayList<>(current));
      return;
    }

    if (remaining < 0) {
      return;
    }

    for (int i = idx; i < candidates.length; i++) {

      current.add(candidates[i]);
      backtrack(candidates, remaining - candidates[i], i + 1, current, ans);
      current.remove(current.size() - 1);

    }

  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(candidates, target, 0, new ArrayList<>(), ans);
    return ans;
  }

}
