package leetcode;

import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class Check_Completeness_of_a_Binary_Tree {
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
