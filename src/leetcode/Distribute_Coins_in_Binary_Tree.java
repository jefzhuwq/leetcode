package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree
 */
public class Distribute_Coins_in_Binary_Tree {

    int num_moves;

    public int distributeCoins(TreeNode root) {
        num_moves = 0;
        give_coins(root);
        return num_moves;
    }

    public int give_coins(TreeNode node) {
        if (node==null) {
            return 0;
        }
        int left = give_coins(node.left);
        int right = give_coins(node.right);
        num_moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}
