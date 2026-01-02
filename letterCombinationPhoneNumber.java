import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

  private void backtrack(String digits, int idx, Map<Character, String> map, StringBuilder current, List<String> ans) {

    if (current.length() == digits.length()) {
      ans.add(current.toString());
      return;
    }

    String charSeq = map.get(digits.charAt(idx));

    for (int i = 0; i < charSeq.length(); i++) {
      char currentChar = charSeq.charAt(i);
      current.append(currentChar);
      backtrack(digits, idx + 1, map, current, ans);
      current.deleteCharAt(current.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {

    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    Map<Character, String> digitToLetters = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz");
    List<String> ans = new ArrayList<>();
    backtrack(digits, 0, digitToLetters, new StringBuilder(), ans);
    return ans;
  }
}
