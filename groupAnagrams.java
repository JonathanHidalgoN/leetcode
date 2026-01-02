import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

  private String createUniqueFreqRepresentation(String string) {

    HashMap<Character, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < string.length(); i++) {
      char cc = string.charAt(i);
      freqMap.put(cc, freqMap.getOrDefault(cc, 0) + 1);
    }

    char[] chars = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'w', 'v', 'x', 'y', 'z', };

    StringBuilder stringBuilder = new StringBuilder("");

    for (char myChar : chars) {
      stringBuilder.append(myChar + freqMap.getOrDefault(myChar, 0));
    }

    return stringBuilder.toString();

  }

  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> ans = new ArrayList<>();
    HashMap<String, List<String>> uniqueStringAnagramMap = new HashMap<>();
    for (String currentString : strs) {
      String uniqueRep = createUniqueFreqRepresentation(currentString);

      if (uniqueStringAnagramMap.containsKey(uniqueRep)) {
        uniqueStringAnagramMap.get(uniqueRep).add(currentString);
      } else {
        List<String> newList = new ArrayList<>();
        newList.add(currentString);
        uniqueStringAnagramMap.put(uniqueRep, newList);
      }
    }

    for (String key : uniqueStringAnagramMap.keySet()) {
      ans.add(uniqueStringAnagramMap.get(key));
    }

    return ans;
  }
}
