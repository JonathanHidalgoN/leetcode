import java.util.HashMap;
import java.util.Map;

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

  private int height(TreeNode root, Map<TreeNode, Integer> map) {

    if (root == null) {
      return 0;
    }

    if (map.containsKey(root)) {
      return map.get(root);
    }

    int nodeHeight = 1 + Math.max(height(root.left, map), height(root.right, map));
    map.put(root, nodeHeight);

    return nodeHeight;

  }

  private boolean helper(TreeNode root, Map<TreeNode, Integer> map) {

    if (root == null) {
      return true;
    }

    int leftHeight = height(root.left, map);
    int rightHeight = height(root.right, map);

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }

    return helper(root.left, map) && helper(root.right, map);

  }

  public boolean isBalanced(TreeNode root) {
    Map<TreeNode, Integer> map = new HashMap<>();
    return helper(root, map);

  }
}
