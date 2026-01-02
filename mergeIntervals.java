import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public int[][] merge(int[][] intervals) {

    // quickSort(intervals, 0, intervals.length - 1);
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    List<int[]> ans = new ArrayList<>();
    int[] potentialAns;

    for (int i = 0; i < intervals.length; i++) {

      int[] currentInterval = intervals[i];

      if (i + 1 > intervals.length - 1) {
        ans.add(currentInterval);
        break;
      }

      int[] nextInterval = intervals[i + 1];

      if (currentInterval[1] >= nextInterval[0]) {
        nextInterval[0] = currentInterval[0];
        nextInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
      } else {
        ans.add(currentInterval);
      }
    }

    return ans.toArray(new int[0][]);

  }

  private void quickSort(int[][] intervals, int start, int stop) {
    if (start < stop) {
      int p = partition(intervals, start, stop);
      quickSort(intervals, start, p - 1);
      quickSort(intervals, p + 1, stop);
    }
  }

  private int partition(int[][] intervals, int start, int stop) {

    int pivotIdx = stop;
    int partitionPoint = start;

    for (int i = start; i < stop; i++) {
      if (intervals[i][0] < intervals[pivotIdx][0]) {
        swap(intervals, partitionPoint, i);
        partitionPoint++;
      }
    }

    swap(intervals, pivotIdx, partitionPoint);

    return partitionPoint;

  }

  private void swap(int[][] intervals, int i, int j) {
    int[] tmp = intervals[i];
    intervals[i] = intervals[j];
    intervals[j] = tmp;
  }

}
