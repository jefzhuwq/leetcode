package leetcode;


import ds.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 */
public class Flatten_Binary_Tree_to_Linked_List {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty()) {
            TreeNode current_node = stack.pop();
            if (current_node.right != null) {
                stack.push(current_node.right);
            }
            if (current_node.left != null) {
                stack.push(current_node.left);
            }
            if (!stack.isEmpty()) {
                current_node.right = stack.peek();
            }

            current_node.left = null;
        }
    }
}
