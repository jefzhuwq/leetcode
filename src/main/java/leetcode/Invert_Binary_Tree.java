package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree
 * 226. Invert Binary Tree
 */
public class Invert_Binary_Tree {

    /**
     * idea: left = right, right = left
     * time: O(n) as we traverse all nodes in tree
     * space: O(1) if exclude stack space by recursive
     * @param root
     * @return
     */
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
