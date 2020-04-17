package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/univalued-binary-tree
 */
public class Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        boolean left_univaled = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
        boolean right_univaled = root.right == null || root.right.val == root.val && isUnivalTree(root.right);
        return left_univaled && right_univaled;
    }
}
