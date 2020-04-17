package basic;

import java.util.*;

/**
 * Binary Tree - breadth first search
 */
public class BinaryTreeBFS {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinaryTreeBFS bfs = new BinaryTreeBFS();
        bfs.bfs_recursive(bfs.constructBinaryTree());
    }

    public TreeNode constructBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode level_1_1 = new TreeNode(2);
        TreeNode level_1_2 = new TreeNode(3);
        root.left = level_1_1;
        root.right = level_1_2;

        TreeNode level_2_1 = new TreeNode(4);
        TreeNode level_2_2 = new TreeNode(5);
        TreeNode level_2_3 = new TreeNode(6);
        TreeNode level_2_4 = new TreeNode(7);

        level_1_1.left = level_2_1;
        level_1_1.right = level_2_2;

        level_1_2.left = level_2_3;
        level_1_2.right = level_2_4;

        return root;
    }

    public List<Integer> bfs_non_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }

    public void bfs_recursive(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        bfs_recursive_helper(q);
    }

    public void bfs_recursive_helper(Queue<TreeNode> q) {
        if (q.isEmpty()) {
            return;
        }
        TreeNode node = q.poll();
        System.out.println(node.val);
        if (node.left!=null) {
            q.offer(node.left);
        }
        if (node.right!=null) {
            q.offer(node.right);
        }
        bfs_recursive_helper(q);
    }
}
