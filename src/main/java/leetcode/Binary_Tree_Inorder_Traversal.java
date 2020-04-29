package leetcode;

import ds.TreeNode;
import org.junit.jupiter.api.Test;
import utils.BinaryTreeDataProvider;;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 94. Binary Tree Inorder Traversal
 */
public class Binary_Tree_Inorder_Traversal {

    /**
     * idea: iterative solution, using stack
     * 1. keep pushing left child to stack until null.
     * 2. pop the element from stack, and add to final result.
     * 3. set current to the current's right, then keep pushing to left leaf again.
     * time: O(n) as we need to traverse all the nodes in the tree.
     * space: O(n) as we define the stack.
     * @param root
     * @return
     */
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
            current = stack.pop();
            output.add(current.val);
            current = current.right;
        }

        return output;
    }

    @Test
    public void test() {
        TreeNode root = BinaryTreeDataProvider.constructBinaryTree();
        List<Integer> expected = Arrays.asList(new Integer[]{4, 2, 9, 8, 5, 1, 6, 3});
        assertEquals(expected, inorderTraversal(root));
    }
}
