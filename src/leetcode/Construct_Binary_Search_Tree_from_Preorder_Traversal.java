package leetcode;

import ds.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class Construct_Binary_Search_Tree_from_Preorder_Traversal {

    public static void main(String[] args) {
        int[] input = {8,5,1,7,10,12};
        Construct_Binary_Search_Tree_from_Preorder_Traversal entity = new Construct_Binary_Search_Tree_from_Preorder_Traversal();
        System.out.println(entity.bstFromPreorder(input).val);
    }

    int i=0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MAX_VALUE);
    }

    // recursive way, second parameter is bound, initial bound is Int.Max
    public TreeNode help(int[] A, int bound) {
        // i reaches to out of A, or current element in A is larger than bound.
        System.out.println("call help with bound=" + bound);
        if (i < A.length ) {
            System.out.println("help current A[i]=" + A[i]);
        }
        if (i == A.length || A[i] > bound) {
            return null;
        }
        System.out.println("Construct new node: " + A[i]);
        TreeNode root = new TreeNode(A[i]);
        i++;

        System.out.println("i: " + i);
        System.out.println("root.val: " + root.val);
        // using current root val as split boundary, anything smaller will go to left subtree, larger will go to right subtree
        root.left = help(A, root.val);

        System.out.println("bound: " + bound);
        root.right = help(A, bound);
        return root;
    }
}
