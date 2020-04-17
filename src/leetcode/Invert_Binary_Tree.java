package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree
 */
public class Invert_Binary_Tree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
