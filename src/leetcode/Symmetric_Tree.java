package leetcode;

/**
 * https://leetcode.com/problems/symmetric-tree
 */
public class Symmetric_Tree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetricTree(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
