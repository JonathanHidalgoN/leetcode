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

  private boolean validate(TreeNode root, Integer max, Integer min) {

    if (root == null) {
      return true;
    }

    int currentVal = root.val;

    if ((max == null || currentVal < max) && (min == null || currentVal > min)) {

      return validate(root.left, currentVal, min) && validate(root.right, max, currentVal);

    }

    return false;

  }

  public boolean isValidBST(TreeNode root) {

    if (root == null) {
      return true;
    }

    return validate(root.left, root.val, null) && validate(root.right, null, root.val);

  }
}
