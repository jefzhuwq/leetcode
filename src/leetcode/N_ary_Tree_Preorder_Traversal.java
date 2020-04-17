package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal
 */
public class N_ary_Tree_Preorder_Traversal {
    private class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node child: node.children) {
                stack.add(child);
            }
        }

        return output;
    }
}
