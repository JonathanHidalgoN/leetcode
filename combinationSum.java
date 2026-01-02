import java.util.ArrayList;
import java.util.List;

class Solution {
  private void backtrack(int[] candidates, int remaining, int currentElementIdx, List<List<Integer>> ans,
      List<Integer> current) {

    if (remaining == 0) {
      ans.add(new ArrayList<>(current));
      return;
    }

    if (remaining < 0) {
      return;
    }

    for (int i = currentElementIdx; i < candidates.length; i++) {
      current.add(candidates[i]);
      backtrack(candidates, remaining - candidates[i], i, ans, current);
      current.remove(current.size() - 1);
    }

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(candidates, target, 0, ans, new ArrayList<Integer>());
    return ans;
  }
}
