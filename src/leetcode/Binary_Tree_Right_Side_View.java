package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class Binary_Tree_Right_Side_View {

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
