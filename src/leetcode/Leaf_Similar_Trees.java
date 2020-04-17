package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees
 */
public class Leaf_Similar_Trees {

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

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        List<Integer> leafList1 = new ArrayList<>();
        Leaf_Similar_Trees solution = new Leaf_Similar_Trees();
        TreeNode root = solution.constructBinaryTree();
        solution.getLeafList(root, leafList1);
        System.out.println(leafList1.toString());
    }


    public void getLeafList(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            getLeafList(node.left, leafList);
        }
        if (node.right != null) {
            getLeafList(node.right, leafList);
        }
        if (node.left == null && node.right == null) {
            leafList.add(node.val);
        }
        return;
    }
}
