class Solution {

  private int expand(String s, int start, boolean even) {

    int stop = even ? start + 1 : start;

    if (stop > s.length() - 1 || s.charAt(start) != s.charAt(stop)) {
      return 0;
    }

    while (start > 0 && stop < s.length() - 1 && s.charAt(start - 1) == s.charAt(stop + 1)) {
      start--;
      stop++;
    }

    return stop - start + 1;

  }

  public String longestPalindrome(String s) {

    StringBuilder max = new StringBuilder("");

    for (int i = 0; i < s.length(); i++) {

      int evenLen = expand(s, i, true);
      int oddLen = expand(s, i, false);

      if (evenLen > max.length() || oddLen > max.length()) {

        if (evenLen > oddLen) {
          max = new StringBuilder(s.substring(i - (evenLen - 2) / 2, i + 1 + 1 + (evenLen - 2) / 2));
        } else {
          max = new StringBuilder(s.substring(i - (oddLen - 1) / 2, i + 1 + (oddLen - 1) / 2));
        }
      }

    }

    return max.toString();

  }
}
