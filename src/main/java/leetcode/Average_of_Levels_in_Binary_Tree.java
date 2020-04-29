package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 637. Average of Levels in Binary Tree
 */
public class Average_of_Levels_in_Binary_Tree {
    /**
     * idea:
     *      1. iterative way, using queue
     *      2. put root into queue.
     *      3. loop queue, level order traverse, get average from each row
     *      4.      at end of each row, calculate average
     * time: O(n) where n is the number of nodes, because we traverse every node of tree.
     * space: O(2 ^ (h-1)) where h is height of tree, because the max size of queue will be number of nodes at last row
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> row = new LinkedList<>();
        row.offer(root);
        while (!row.isEmpty()) {
            int rowSize = row.size();
            long rowSum = 0;
            for (int i = 0; i < rowSize; i++) {
                TreeNode node = row.poll();
                if (node.left != null) {
                    row.offer(node.left);
                }
                if (node.right != null) {
                    row.offer(node.right);
                }
                rowSum += node.val;
            }
            res.add(rowSum * 1.0 / rowSize);
        }
        return res;
    }

    /**
     * idea: recursive solution, dfs
     *      1. List to count number of nodes on each row
     *      2. List of sum of each row
     *      3. Call helper method to start from root.
     * time: O(n) where n is number of nodes, because we need to traverse every node of the tree
     * space: O(h) where h is the height of the tree.
     * @param root
     * @return
     */
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        int level = 0;
        avgOfLevels(root, level, res, count);
        return res;
    }

    /**
     * Helper method to:
     * 1. set current level's sum
     * 2. recursively traverse left and right child until current node is null.
     *
     * @param node
     * @param level
     * @param sum
     * @param count
     */
    private void avgOfLevels(final TreeNode node, final int level, final List<Double> sum, final List<Integer> count) {
        if (node == null) {
            return;
        }
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + node.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(node.val * 1.0);
            count.add(1);
        }
        avgOfLevels(node.left, level+1, sum, count);
        avgOfLevels(node.right, level+1, sum, count);
    }
}
