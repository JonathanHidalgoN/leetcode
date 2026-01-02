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

  private int explore(TreeNode root, int currentDepth) {

    if (root == null) {
      return currentDepth;
    }

    return Math.max(explore(root.left, currentDepth + 1), explore(root.right, currentDepth + 1));

  }

  public int maxDepth(TreeNode root) {
    int maxDepth = explore(root, 0);
    return maxDepth;
  }
}
