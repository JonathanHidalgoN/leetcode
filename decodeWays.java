import java.util.HashSet;
import java.util.Set;

class Solution {

  // Remember substring is exclusive upper bound so s.substring(1,2) returns one
  public int numDecodings(String s) {

    if (s.length() == 0) {
      return 0;
    }

    // Here we need to add elements
    Set<String> validStrings = new HashSet<>();
    for (int i = 1; i <= 26; i++) {
      validStrings.add(String.valueOf(i));
    }

    // Number of valid ways of substring that starts at 0 and ends at i
    int[] memo = new int[s.length()];

    memo[0] = validStrings.contains(s.substring(0, 1)) ? 1 : 0;

    if (s.length() == 1) {
      return memo[0];
    }

    memo[1] = 0;
    if (validStrings.contains(s.substring(1, 2))) {
      memo[1] += memo[0]; // Can reach by taking single digit
    }
    if (validStrings.contains(s.substring(0, 2))) {
      memo[1] += 1; // Can reach by taking two digits from start
    }

    for (int i = 2; i < s.length(); i++) {
      // Have two ways to reach index i
      // Either from i-1 take one char
      int oneChar = validStrings.contains(s.substring(i, i + 1)) ? memo[i - 1] : 0;
      // From i-2 take two chars, that is why we check substring(i-1,i)
      int twoChar = validStrings.contains(s.substring(i - 1, i + 1)) ? memo[i - 2] : 0;
      // Number of valid ways is the combination
      memo[i] = oneChar + twoChar;
    }

    return memo[s.length() - 1];

  }
}
