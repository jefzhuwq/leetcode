package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * binary tree - depth first search
 * <p>
 * DFS contains 3 ways
 * 1. Pre-order (NLR)
 * 2. In-order (LNR)
 * 3. Post-order (LRN)
 * N means root node
 */
public class BinaryTreeDFS {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinaryTreeDFS dfs = new BinaryTreeDFS();

        // non-recursive
        System.out.println("dfs non-recursive pre-order");
        dfs.dfs_non_recursive_pre_order(dfs.constructBinaryTree());
        System.out.println();

        System.out.println("dfs non-recursive in-order");
        dfs.dfs_non_recursive_in_order(dfs.constructBinaryTree());
        System.out.println();

        System.out.println("dfs non-recursive post-order");
        dfs.dfs_non_recursive_post_order(dfs.constructBinaryTree());
        System.out.println();

        // recursive
        List<Integer> res = new ArrayList<>();

        // pre-order
        System.out.println("dfs recursive pre-order");
        dfs.dfs_recursive_pre_order(dfs.constructBinaryTree());
        System.out.println();
        // in-order
        System.out.println("dfs recursive in-order");
        dfs.dfs_recursive_in_order(dfs.constructBinaryTree());
        System.out.println();
        // post-order
        System.out.println("dfs recursive post-order");
        dfs.dfs_recursive_post_order(dfs.constructBinaryTree());
        System.out.println();
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

    public void dfs_non_recursive_pre_order(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + ", ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void dfs_non_recursive_in_order(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + ", ");
                root = root.right;
            }
        }
    }

    public void dfs_non_recursive_post_order(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastNodeVisited = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right !=null && lastNodeVisited !=peekNode.right) {
                    root = peekNode.right;
                } else {
                    System.out.print(peekNode.val + ", ");
                    lastNodeVisited = stack.pop();
                }
            }
        }
    }

    public List<Integer> dfs_recursive(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        res = dfs_recursive(root.left, res);
        res = dfs_recursive(root.right, res);
        return res;
    }


    public void dfs_recursive_pre_order(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ", ");
        dfs_recursive_pre_order(root.left);
        dfs_recursive_pre_order(root.right);
    }

    public void dfs_recursive_in_order(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs_recursive_in_order(root.left);
        System.out.print(root.val + ", ");
        dfs_recursive_in_order(root.right);
    }

    public void dfs_recursive_post_order(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs_recursive_post_order(root.left);
        dfs_recursive_post_order(root.right);
        System.out.print(root.val + ", ");
    }
}
