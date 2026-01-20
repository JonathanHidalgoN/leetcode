import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {

    if (wordDict.size() == 0) {
      return false;
    }

    Set<String> wordsSet = new HashSet<>(wordDict);
    boolean[] memo = new boolean[s.length() + 1];
    memo[0] = true;

    for (int i = 1; i <= s.length(); i++) {

      for (int j = 0; j < i; j++) {
        if (memo[j] && wordsSet.contains(s.substring(j, i))) {
          memo[i] = true;
          break;
        }
      }

    }

    return memo[memo.length - 1];

  }
}
