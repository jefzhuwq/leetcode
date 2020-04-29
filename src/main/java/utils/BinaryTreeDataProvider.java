package utils;

import ds.TreeNode;

public class BinaryTreeDataProvider {
    /**
     *       1
     *      / \
     *     2   3
     *    / \  /
     *   4  5  6
     *     /
     *    8
     *   /
     *  9
     * @return
     */
    public static TreeNode constructBinaryTree() {
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
