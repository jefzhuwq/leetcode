package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Balanced_Binary_Tree {

    public static void main(String[] args) {
        Balanced_Binary_Tree entity = new Balanced_Binary_Tree();
        TreeNode root = entity.constructBinaryTree();
        System.out.println(entity.isBalanced(root));
    }

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


    public TreeNode constructBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode level_1_1 = new TreeNode(2);
        TreeNode level_1_2 = new TreeNode(3);
        root.left = level_1_1;
        root.right = level_1_2;

        TreeNode level_2_1 = new TreeNode(4);
        TreeNode level_2_2 = new TreeNode(5);
        TreeNode level_2_3 = new TreeNode(6);
        //TreeNode level_2_4 = new TreeNode(7);

        level_1_1.left = level_2_1;
        level_1_1.right = level_2_2;

        TreeNode level_3_1 = new TreeNode(8);
        level_2_2.left = level_3_1;

        TreeNode level_4_1 = new TreeNode(9);
        level_3_1.left = level_4_1;

        level_1_2.left = level_2_3;
//        level_1_2.right = level_2_4;

        return root;
    }
}
