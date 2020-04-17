package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        return output;
    }
}
