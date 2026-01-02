class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public boolean hasCycle(ListNode head) {

    if (head == null) {
      return false;
    }

    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer.next != null && fastPointer.next.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;

      if (fastPointer == slowPointer) {
        return true;
      }

    }

    return false;
  }
}
