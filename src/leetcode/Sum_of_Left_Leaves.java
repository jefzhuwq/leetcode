package leetcode;


import ds.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-left-leaves
 */
public class Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum_of_left_leaves = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum_of_left_leaves += root.left.val;
            } else {
                sum_of_left_leaves += sumOfLeftLeaves(root.left);
            }
        }

        if (root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                sum_of_left_leaves += sumOfLeftLeaves(root.right);
            }
        }

        return sum_of_left_leaves;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum_of_left_leaves = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum_of_left_leaves += node.left.val;
                } else {
                    stack.add(node.left);
                }
            }

            if (node.right != null)
                if (node.right.left != null || node.right.right != null) {
                    stack.add(node.right);
                }
        }

        return sum_of_left_leaves;
    }
}
