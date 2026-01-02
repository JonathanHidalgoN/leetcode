class Solution {

  public static void main(String[] args) {
    System.out.println("Going to run isPalindrome program!");
    String input = "aabb*bbaa";
    boolean output = isPalindrome(input);
    System.out.println("The string " + input + "is palindrome " + output);
  }

  public static boolean isPalindrome(String s) {

    s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;

  }
}
