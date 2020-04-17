package leetcode;

import ds.TreeNode;

public class Split_BST {

    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[]{null, null};
        if (root == null) return res;
        // need to continue find larger part
        if (root.val <= V) {
            // continue find the right sub-tree
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0]= root;
        } else {
            // continue find smaller part
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }
}
