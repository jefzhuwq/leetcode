package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class Max_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
