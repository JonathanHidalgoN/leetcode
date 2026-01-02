import java.util.ArrayList;
import java.util.List;

class Solution {
  public int lengthOfLIS(int[] nums) {

    List<List<Integer>> dpList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      List<Integer> oneElementList = new ArrayList<>();

      oneElementList.add(nums[i]);
      dpList.add(oneElementList);

      for (int j = 0; j < i; j++) {
        List<Integer> prevList = dpList.get(j);
      }
    }

  }
}
