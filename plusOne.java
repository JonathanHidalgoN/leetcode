class Solution {
  public int[] plusOne(int[] digits) {

    int remaining = 1;
    int idx = digits.length - 1;

    while (remaining == 1) {

      if (idx == -1) {
        break;
      }

      if (digits[idx] == 9) {
        digits[idx] = 0;
        remaining = 1;
        idx--;
      } else {
        digits[idx] += 1;
        remaining = 0;
        return digits;
      }
    }

    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    for (int i = 1; i < newDigits.length; i++) {
      newDigits[i] = 0;
    }

    return newDigits;

  }
}
