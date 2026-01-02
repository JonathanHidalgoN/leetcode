import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public static void main(String[] args) {

    System.out.println("Main program running");
    int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    boolean containsDuplicate1 = containsDuplicate(nums);
    System.out.println("Nums " + Arrays.toString(nums) + " contain duplicate: " + containsDuplicate1);
    int[] nums1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
    boolean containsDuplicate2 = containsDuplicate(nums1);
    System.out.println("Nums " + Arrays.toString(nums1) + " contain duplicate: " + containsDuplicate2);

  }

  public static boolean containsDuplicate(int[] nums) {

    Set<Integer> numsSet = new HashSet<>();
    for (int num : nums) {
      if (numsSet.contains(num)) {
        return true;
      } else {
        numsSet.add(num);
      }
    }

    return false;
  }
}
