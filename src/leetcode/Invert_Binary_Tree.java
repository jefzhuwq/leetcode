package leetcode;

/**
 * https://leetcode.com/problems/invert-binary-tree
 */
public class Invert_Binary_Tree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

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
