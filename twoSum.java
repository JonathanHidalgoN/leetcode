import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      int currentElement = nums[i];
      int newTarget = target - currentElement;
      if (map.containsKey(newTarget)) {
        return new int[] { i, map.get(newTarget) };
      }

      map.put(currentElement, i);

    }

    return new int[] {};
  }
}
