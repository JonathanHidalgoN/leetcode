class Solution {
  public boolean mergeTriplets(int[][] triplets, int[] target) {

    boolean condition1 = false;
    boolean condition2 = false;
    boolean condition3 = false;

    for (int[] triplet : triplets) {

      // if (condition1 && condition2 && condition3) {
      // return true;
      // }

      if (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
        condition1 = true;
      }

      if (triplet[1] == target[1] && triplet[0] <= target[0] && triplet[2] <= target[2]) {
        condition2 = true;
      }

      if (triplet[2] == target[2] && triplet[1] <= target[1] && triplet[0] <= target[0]) {
        condition3 = true;
      }

    }

    if (condition1 && condition2 && condition3) {
      return true;
    } else {
      return false;
    }

  }
}
