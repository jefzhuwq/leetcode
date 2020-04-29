package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 199. Binary Tree Right Side View
 */
public class Binary_Tree_Right_Side_View {

    /**
     * idea: level order traverse. iterative solution, using queue.
     * every first node in to final result. ignore rest of the nodes of that row.
     * Note: for next row, first add right child, then left child.
     * time: O(n) as we traverse all the nodes.
     * space: O(2 ^ (h -1))
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current_node = queue.poll();
                if (i==0) {
                    result.add(current_node.val);
                }
                if (current_node.right!=null) {
                    queue.offer(current_node.right);
                }
                if (current_node.left!=null) {
                    queue.offer(current_node.left);
                }
            }
        }
        return result;
    }
}
