import java.util.HashSet;
import java.util.Set;

class Solution {
  public int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();
    int left = 0;
    int ansMax = 0;

    for (int right = 0; right < s.length(); right++) {

      char currentChar = s.charAt(right);

      if (set.contains(currentChar)) {
        while (set.contains(currentChar)) {
          set.remove(s.charAt(left));
          left++;
        }
      }

      set.add(currentChar);
      ansMax = Math.max(right - left + 1, ansMax);

    }

    return ansMax;

  }
}
