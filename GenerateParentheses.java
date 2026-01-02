import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private void backtrack(int openers, int closers, List<String> ans, StringBuilder current) {

    if (openers == 0 && closers == 0) {
      ans.add(current.toString());
      return;
    }

    if (openers > 0) {
      current.append('(');
      backtrack(openers - 1, closers, ans, current);
      current.deleteCharAt(current.length() - 1);
    }

    if (closers > openers) {
      current.append(')');
      backtrack(openers, closers - 1, ans, current);
      current.deleteCharAt(current.length() - 1);
    }

  }

  public List<String> generateParenthesis(int n) {

    if (n == 0) {
      return Arrays.asList("");
    }

    List<String> ans = new ArrayList<>();
    backtrack(n, n, ans, new StringBuilder());
    return ans;
  }
}
