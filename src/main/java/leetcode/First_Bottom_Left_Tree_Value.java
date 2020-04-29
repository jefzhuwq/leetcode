package leetcode;

import ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value
 * 513. Find Bottom Left Tree Value
 */
public class First_Bottom_Left_Tree_Value {

    /**
     * idea: level order traverse, iterative, define queue
     * time: O(n) as we pretty much traverse every node in the tree
     * space: O(2^(h-1)) as we define a queue to store at most each row's nodes
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            // offer right, then left, the last node in the queue is pretty much the bottom left node
            if (root.right != null) ;
            {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;
    }
}
