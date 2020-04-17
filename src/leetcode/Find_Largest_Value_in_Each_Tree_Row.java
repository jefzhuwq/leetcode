package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 */
public class Find_Largest_Value_in_Each_Tree_Row {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largetst_vals = new ArrayList<>();
        helper_method(root, largetst_vals, 0);
        return largetst_vals;
    }

    public void helper_method(TreeNode root, List<Integer> largest_vals, int level) {
        if (root == null) {
            return;
        }
        if (level == largest_vals.size()) {
            largest_vals.add(root.val);
        } else {
            largest_vals.set(level, Math.max(largest_vals.get(level), root.val));
        }

        helper_method(root.left, largest_vals, level +1);
        helper_method(root.right, largest_vals, level +1);
    }
}
