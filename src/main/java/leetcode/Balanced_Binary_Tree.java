package leetcode;

import ds.TreeNode;
import org.junit.jupiter.api.Test;
import utils.BinaryTreeDataProvider;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 110. Balanced Binary Tree
 */
public class Balanced_Binary_Tree {

    /**
     * idea: get height of left and right subtree,
     * and compare if the diff of left height and right height is more than 1, then return -1, which means it's not balanced.
     * time: O(n) as to get height, we traverse all the nodes once.
     * space: O(1) if we exclude stack space
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        System.out.println("Current node: " + node.val);
        int leftHeight = getHeight(node.left);
        System.out.println(String.format("left height for node %s : %s", node.val, leftHeight));
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        System.out.println(String.format("right height for node %s: %s", node.val,  rightHeight));
        if (rightHeight == -1) {
            return -1;
        }
        // using -1 to represent if it’s not balanced at the leaf node level
        if (Math.abs(leftHeight - rightHeight) > 1)  {
            System.out.println(String.format("return -1 at node %s", node.val));
            return -1;
        }
        System.out.println(String.format("return value for node %s: %s", node.val, (Math.max(leftHeight, rightHeight) + 1)));
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    public void test() {
        TreeNode root = BinaryTreeDataProvider.constructBinaryTree();
        assertTrue(isBalanced(root));
    }
}
