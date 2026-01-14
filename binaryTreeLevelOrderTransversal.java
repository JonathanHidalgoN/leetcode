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
  private void transverse(TreeNode root, int level, List<List<Integer>> ans) {

    if (root == null) {
      return;
    }

    int ansSize = ans.size();
    if (ansSize - 1 < level) {
      List<Integer> newList = new ArrayList<>();
      newList.add(root.val);
      ans.add(newList);
    } else {
      ans.get(level).add(root.val);
    }

    transverse(root.left, level + 1, ans);
    transverse(root.right, level + 1, ans);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    transverse(root, 0, ans);
    return ans;
  }
}
