import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> freqMap = new HashMap<>();

    for (int num : nums) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    List<int[]> freqArray = new ArrayList<>();
    int counter = 0;

    for (Integer key : freqMap.keySet()) {
      int freq = freqMap.get(key);
      freqArray.add(new int[] { key, freq });
      counter++;
    }

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(
        (freqArray1, freqArray2) -> Integer.compare(freqArray1[1], freqArray2[1]));

    for (Integer key : freqMap.keySet()) {
      int freq = freqMap.get(key);
      if (minHeap.size() < k) {
        minHeap.add(new int[] { key, freq });
      }else if()
    }

  }
}
