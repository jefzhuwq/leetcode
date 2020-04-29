package leetcode;


import ds.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 * 114. Flatten Binary Tree to Linked List
 */
public class Flatten_Binary_Tree_to_Linked_List {

    /**
     * Traps:
     * 1. Ask if it's binary search tree, any requirement of binary search tree.
     * 2. Which order? Because it's actually traverse the tree, looks like it's pre-order.
     * 3. It's possible that the root could be empty.
     * Understand:
     * Based on my understand, this problem is a little different, you still keep the same tree, but just make it flatterned, all the nodes are in the right side.
     * <p>
     * idea: iterative way,
     * time: O(n)
     * space: O(1)
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // define another node point same to root
        TreeNode node = root;
        // while node not nulll
        while (node != null) {
            // Attatches the right sub-tree to the rightmost leaf of the left sub-tree:
            if (node.left != null) {
                // define a rightMost node to current node's left
                TreeNode rightMost = node.left;
                // while rightMost's right is not null, go deeper, to find the most right node
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                // then after finding the most right node, move the current node's right to rightMost's right.
                rightMost.right = node.right;
                // Makes the left sub-tree to the right sub-tree:
                // then move the current left branch to current node's right
                node.right = node.left;
                // set current node's left is null
                node.left = null;
            }
            // move curser to next right child
            node = node.right;
        }
    }

    /**
     * This is not an acceptable solution, even if it's printing out the list.
     * The requirement is to print out each level. There's another problem ask almost the same question.
     */
    private ArrayList<TreeNode> flattern1(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root);
        list.addAll(this.flattern1(root.left));
        list.addAll(this.flattern1(root.right));
        return list;
    }
}
