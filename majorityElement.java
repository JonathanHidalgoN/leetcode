import java.util.HashMap;
import java.util.Map;

class Solution {
  public int majorityElement(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();
    int target = Math.floorDiv(nums.length, 2);

    for (int num : nums) {
      int newVal = map.getOrDefault(num, 0) + 1;
      if (newVal > target) {
        return num;
      } else {
        map.put(num, newVal);
      }
    }

    return -1;

  }
}
