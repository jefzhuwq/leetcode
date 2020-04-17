package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree
 */
public class Search_in_a_Binary_Search_Tree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }



}
