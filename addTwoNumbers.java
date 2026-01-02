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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int remainder = 0;
    ListNode l1H = l1;

    while (l1 != null) {

      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;
      int currentVal = l1Val + l2Val + remainder;
      remainder = 0;

      if (currentVal >= 10) {
        currentVal -= 10;
        remainder = 1;
      }

      l1.val = currentVal;

      l1 = l1.next;

      if (l2 != null) {
        l2 = l2.next;
      }

      if (l1 == null && l2 != null) {
        l1 = l2;
        l2 = null;
      }

    }

    return l1H;

  }
}
