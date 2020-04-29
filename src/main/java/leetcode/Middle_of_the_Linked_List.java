package leetcode;

import ds.ListNode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list
 */
public class Middle_of_the_Linked_List {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a_pointer = head;
        ListNode b_pointer = head;

        while (b_pointer!=null && b_pointer.next!=null) {
            a_pointer = a_pointer.next;
            b_pointer = b_pointer.next.next;
        }

        return a_pointer;
    }
}
