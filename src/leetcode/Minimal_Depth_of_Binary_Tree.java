package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 */
public class Minimal_Depth_of_Binary_Tree {

    public static void main(String[] args) {
        Minimal_Depth_of_Binary_Tree entity = new Minimal_Depth_of_Binary_Tree();
        TreeNode root = entity.constructBinaryTree();
        System.out.println(entity.minDepth(root));
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        System.out.println("at node " + root.val);
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        System.out.println(String.format("node %s left %s right %s", root.val, left, right));
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        else {
            return Math.min(left, right) + 1;
        }
    }
}
