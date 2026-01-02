import java.util.HashSet;
import java.util.Set;

public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    Set<ListNode> set = new HashSet<>();
    ListNode pA = headA;
    ListNode pB = headB;

    while (pA != null) {
      set.add(pA);
      pA = pA.next;
    }

    while (pB != null) {
      if (set.contains(pB)) {
        return pB;
      }
      pB = pB.next;
    }

    return null;

  }
}
