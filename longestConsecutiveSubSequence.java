import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

  private int findAhead(Set<Integer> numsSet, int element) {
    int target = element + 1;
    int currentLen = 0;

    while (numsSet.contains(target)) {
      numsSet.remove(target);
      currentLen++;
      target++;
    }

    return currentLen;
  }

  private int findBehind(Set<Integer> numsSet, int element) {
    int target = element - 1;
    int currentLen = 0;

    while (numsSet.contains(target)) {
      numsSet.remove(target);
      currentLen++;
      target--;
    }

    return currentLen;
  }

  public int longestConsecutive(int[] nums) {

    Set<Integer> numsSet = new HashSet<>();
    for (int num : nums)
      numsSet.add(num);

    int longestConsecutiveSeqSoFar = 0;
    int currentLenSubSeq = 0;

    while (!numsSet.isEmpty()) {

      int element = numsSet.iterator().next();
      numsSet.remove(element);
      currentLenSubSeq = 1 + findAhead(numsSet, element) + findBehind(numsSet, element);
      longestConsecutiveSeqSoFar = Math.max(longestConsecutiveSeqSoFar, currentLenSubSeq);
    }

    return longestConsecutiveSeqSoFar;

  }
}
