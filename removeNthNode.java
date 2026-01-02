public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode ahead = head;
    ListNode behind = head;

    for (int i = 0; i < n; i++) {
      ahead = ahead.next;
    }

    if (ahead == null) {
      return head.next;
    }

    while (ahead.next != null) {
      ahead = ahead.next;
      behind = behind.next;
    }

    behind.next = behind.next.next;
    return head;

  }
}
