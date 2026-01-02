import java.util.HashMap;
import java.util.Map;

class DetectSquares {

  private Map<String, Integer> freqMap;

  public DetectSquares() {
    freqMap = new HashMap<String, Integer>();
  }

  public void add(int[] point) {
    String pointKey = createPointKey(point);
    int newFreq = freqMap.getOrDefault(pointKey, 0) + 1;
    freqMap.put(pointKey, newFreq);
  }

  private String createPointKey(int[] point) {
    return point[0] + "," + point[1];
  }

  public int count(int[] point) {

    int counter = 0;

    for (String key : freqMap.keySet()) {

      String[] parts = key.split(",");
      int[] currentPoint = new int[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) };
      int width = Math.abs(point[0] - currentPoint[0]);
      int height = Math.abs(point[1] - currentPoint[1]);

      if (width != height || width == 0) {
        continue;
      }

      int[] firstTargetPoint = new int[] { point[0], currentPoint[1] };
      int[] secondTargetPoint = new int[] { currentPoint[0], point[1] };
      String firstTargetPointKey = createPointKey(firstTargetPoint);
      String secondTargetPointKey = createPointKey(secondTargetPoint);

      if (freqMap.containsKey(firstTargetPointKey) && freqMap.containsKey(secondTargetPointKey)) {

        int currentPointFreq = freqMap.get(key);
        int firstTargetPointFreq = freqMap.get(firstTargetPointKey);
        int secondTargetPointFreq = freqMap.get(secondTargetPointKey);
        int totalNumberOfSquares = currentPointFreq * firstTargetPointFreq * secondTargetPointFreq;
        counter += totalNumberOfSquares;

      }

    }

    return counter;

  }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
