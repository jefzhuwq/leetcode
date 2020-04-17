package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class Lowest_Common_Ancestor_Node_of_a_BinaryTree {
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


    public static void main(String []args) {
        Lowest_Common_Ancestor_Node_of_a_BinaryTree entity = new Lowest_Common_Ancestor_Node_of_a_BinaryTree();
        TreeNode root = entity.constructBinaryTree();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(entity.lowestCommonAncestor(root, p, q).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = this.help(root, p, q);
        return ans;
    }

    public TreeNode help(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        System.out.println(String.format("root:%s", node.val));
        if (node.val == p.val || node.val == q.val) {
            return node;
        }
        TreeNode left = help(node.left, p, q);
        TreeNode right = help(node.right, p, q);
        System.out.print(left == null? "left is null," : "left:" + left.val + ",");
        System.out.print(right == null? "right is null," : "right:" + left.val + ",");
        System.out.println();
        if (left !=null && right !=null) {
            return node;
        }
        if (left == null && right == null) {
            return null;
        }
        return left !=null ? left : right;
    }
}
