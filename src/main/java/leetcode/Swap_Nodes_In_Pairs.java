package leetcode;

import ds.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class Swap_Nodes_In_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while (current.next!=null && current.next.next!=null) {
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;
            first_node.next = second_node.next;
            current.next = second_node;
            current.next.next = first_node;
            current = current.next.next;
        }
        return temp.next;
    }
}
