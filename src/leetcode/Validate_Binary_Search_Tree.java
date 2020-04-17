package leetcode;

import ds.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Validate_Binary_Search_Tree {

    public static void main(String[] args) {
        Validate_Binary_Search_Tree solution = new Validate_Binary_Search_Tree();
        TreeNode root = solution.constructBST();
        System.out.println(solution.isValidBST(root));
    }

    public TreeNode constructBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode level_1_1 = new TreeNode(2);
        TreeNode level_1_2 = new TreeNode(3);
        root.left = level_1_1;
        root.right = level_1_2;

        TreeNode level_2_1 = new TreeNode(4);
        TreeNode level_2_2 = new TreeNode(5);
        TreeNode level_2_3 = new TreeNode(6);
        TreeNode level_2_4 = new TreeNode(7);

        level_1_1.left = level_2_1;
        level_1_1.right = level_2_2;

        level_1_2.left = level_2_3;
        level_1_2.right = level_2_4;

        return root;
    }

    public TreeNode constructBST() {
        TreeNode root = new TreeNode(2);
        TreeNode level_1_1 = new TreeNode(1);
        TreeNode level_1_2 = new TreeNode(3);
        root.left = level_1_1;
        root.right = level_1_2;

        return root;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        Integer currentVal = null;
        while (node!=null || !stack.isEmpty()) {
            while (node!=null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (currentVal!=null && node.val<=currentVal) {
                return false;
            }
            currentVal = node.val;
            //if (node.right!=null) {
            node = node.right;
            //}
        }

        return true;
    }
}
