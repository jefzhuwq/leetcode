package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 * 515. Find Largest Value in Each Tree Row
 */
public class Find_Largest_Value_in_Each_Tree_Row {

    /**
     * idea: recursively travese the tree, and using a list to store the max value of each row
     * time: O(n) as we need to traverse the entire tree
     * space: O(h) where h is the height of the tree, we create a list which is the same height as tree.
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest_vals = new ArrayList<>();
        // start with level 0, and empty list
        helper_method(root, largest_vals, 0);
        return largest_vals;
    }

    public void helper_method(TreeNode root, List<Integer> largest_vals, int level) {
        if (root == null) {
            return;
        }
        // if current level is beyond size of list, we need to increase. (means we are getting to next level)
        if (level == largest_vals.size()) {
            largest_vals.add(root.val);
        } else {
            largest_vals.set(level, Math.max(largest_vals.get(level), root.val));
        }

        // traverse left and right respectively, and add level
        helper_method(root.left, largest_vals, level + 1);
        helper_method(root.right, largest_vals, level + 1);
    }

    /**
     * idea: iterative, define a queue to BFS
     * time: O(n) as we need to traverse entire tree to get the max value
     * space: O(h + 2^(h-1)) as we need to define the queue and final result.
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues_iterative(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> row = new LinkedList<>();
        row.offer(root);
        int size = row.size();
        while (!row.isEmpty()) {
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = row.poll();
                if (node.left != null) {
                    row.offer(node.left);
                }
                if (node.right != null) {
                    row.offer(node.right);
                }
                if (node.val > rowMax) {
                    rowMax = node.val;
                }
            }
            ret.add(rowMax);
            size = row.size();
        }
        return ret;
    }
}
