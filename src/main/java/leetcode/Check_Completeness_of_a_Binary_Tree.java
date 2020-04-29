package leetcode;

import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * 958. Check Completeness of a Binary Tree
 */
public class Check_Completeness_of_a_Binary_Tree {
    /**
     * bfs, iterate queue, if find null and then non-null, then it shouldn't be complete binary tree
     * 1. define a queue
     * 2. travese every row, poll element from queue
     * 3. keep polling the queue, and if anyone remaining is not null, return false;
     * time: O(n) where n is number of nodes in the tree, as we visit each node
     * space: O(n) as queue stores all the nodes
     * @param root
     * @return
     */
    public boolean isCompleteBinary(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current_node = queue.poll();
            if (current_node == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.offer(current_node.left);
                queue.offer(current_node.right);
            }
        }

        return true;
    }
}
