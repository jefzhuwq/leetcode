package leetcode;

import ds.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 1008. Construct Binary Search Tree from Preorder Traversal
 */
public class Construct_Binary_Search_Tree_from_Preorder_Traversal {

    /**
     * i is for the current position of preorder array
     */
    private int i = 0;

    /**
     * idea: recursive,
     * understand that in pre-order, the first number should be the root node, also it's a binary search tree,
     * which means we can infer the bound (split bound)
     * time: O(n) where n is the total number of elements.
     * space: O(n) where n is the number of elements,
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return help(preorder, Integer.MAX_VALUE);
    }

    /**
     * recursive way, second parameter is bound, initial bound is Int.Max
     *
     * @param A
     * @param bound
     * @return
     */
    public TreeNode help(int[] A, int bound) {
        // i reaches to out of A, or current element in A is larger than bound.
//        System.out.println("call help with bound=" + bound);
//        if (i < A.length ) {
//            System.out.println("help current A[i]=" + A[i]);
//        }
        if (i == A.length || A[i] > bound) {
            return null;
        }
//        System.out.println("Construct new node: " + A[i]);
        TreeNode root = new TreeNode(A[i]);
        i++;

//        System.out.println("i: " + i);
//        System.out.println("root.val: " + root.val);

        // using current root val as split boundary, anything smaller will go to left subtree, larger will go to right subtree
        root.left = help(A, root.val);

//        System.out.println("bound: " + bound);
        root.right = help(A, bound);
        return root;
    }

    @Test
    public void test() {
        int[] input = {8, 5, 1, 7, 10, 12};
        System.out.println(bstFromPreorder(input).val);
    }
}
