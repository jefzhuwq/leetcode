package leetcode;

import ds.TreeNode;
import org.junit.jupiter.api.Test;
import utils.BinaryTreeDataProvider;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 * 814. Binary Tree Pruning
 *
 * Pruning binary tree if it doesn't contain 0.
 */
public class Binary_Tree_Pruning {

    /**
     * idea: recursive solution.
     * Directly call helper function
     * time: O(n) as we need to traverse all the nodes.
     * space: O(1) if exclude stack space.
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        containsOne(root);
        return root;
    }

    /**
     * helper method to traverse left and right subtree to figure out if it contains 1.
     * 1. call recursively to get left and right subtree if contains 1.
     * 2. prune the subtree if doesn't contain.
     * 3. as long as node is 1 or left or right subtree contains 1, return true
     * @param node
     * @return
     */
    public boolean containsOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        boolean left_contains = containsOne(node.left);
        boolean right_contains = containsOne(node.right);
        if(!left_contains) {
            node.left = null;
        }
        if (!right_contains) {
            node.right = null;
        }
        return node.val == 1 || left_contains || right_contains;
    }
}
