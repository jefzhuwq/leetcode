package leetcode;

import ds.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/path-sum
 */
public class Path_Sum {

    /**
     * This is non recursive way
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSUm(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // using stack to preserve nodes (to avoid recursive)
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.add(root);
        sumStack.add(sum - root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            if (currentNode.left == null && currentNode.right == null && sum == 0) {
                return true;
            }

            if (currentNode.left != null) {
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum - currentNode.val);
            }

            if (currentNode.right != null) {
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum - currentNode.val);
            }
        }

        return false;
    }
}
