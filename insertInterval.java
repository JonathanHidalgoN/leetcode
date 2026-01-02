import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {

    if (intervals.length == 0) {
      return new int[][] { newInterval };
    }

    int targetIdx = 0;
    List<int[]> ans = new ArrayList<>();

    while (targetIdx < intervals.length && intervals[targetIdx][1] < newInterval[0]) {
      targetIdx++;
    }

    for (int i = 0; i < targetIdx; i++) {
      ans.add(intervals[i]);
    }

    while (targetIdx < intervals.length && newInterval[1] >= intervals[targetIdx][0]) {
      newInterval[0] = Math.min(newInterval[0], intervals[targetIdx][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[targetIdx][1]);
      targetIdx++;
    }

    ans.add(newInterval);

    for (int i = targetIdx; i < intervals.length; i++) {
      ans.add(intervals[i]);
    }

    return ans.toArray(new int[0][]);

  }
}
