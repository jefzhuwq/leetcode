package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal
 */
public class N_ary_Tree_Postorder_Traversal {
    private class Node {
        public int val;
        public List<Node> children;
//        public Node() {}
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorer(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return output;
    }
}
