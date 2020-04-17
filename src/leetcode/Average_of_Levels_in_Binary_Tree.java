package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class Average_of_Levels_in_Binary_Tree {
    /**
     * Non recursive way
     *
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

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        int level = 0;
        avgOfLevels(root, level, res, count);
        return res;
    }

    public void avgOfLevels(TreeNode node, int level, List<Double> sum, List<Integer> count) {
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
