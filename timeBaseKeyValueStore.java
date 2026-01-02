import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

  private Map<String, List<Object[]>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      List<Object[]> newList = new ArrayList<>();
      map.put(key, newList);
    }
    map.get(key).add(new Object[] { value, timestamp });
  }

  public String get(String key, int timestamp) {

    if (!map.containsKey(key)) {
      return "";
    }

    List<Object[]> valuesList = map.get(key);

    int firstIdx = 0;
    int lastIdx = valuesList.size() - 1;
    String currentVal = "";

    while (firstIdx <= lastIdx) {
      int middle = (firstIdx + lastIdx) / 2;
      Object[] currentElement = valuesList.get(middle);
      int currentTimeStamp = (int) currentElement[1];
      if (currentTimeStamp > timestamp) {
        lastIdx = middle - 1;
      } else if (currentTimeStamp == timestamp) {
        return (String) currentElement[0];
      } else {
        currentVal = (String) currentElement[0];
        firstIdx = middle + 1;
      }
    }
    return currentVal;

  }

}
