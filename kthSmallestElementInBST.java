import java.util.ArrayList;
import java.util.List;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  private void transverse(TreeNode root, List<Integer> list) {

    if (root == null) {
      return;
    }

    transverse(root.left, list);
    list.add(root.val);
    transverse(root.right, list);
  }

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    transverse(root, list);

    return list.get(k - 1);

  }
}
