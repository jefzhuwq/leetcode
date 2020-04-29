package leetcode;

import ds.ListNode;

/**
 * Make linked list odd nodes (based on the index, not the value) together then even nodes
 * 1,2,3,4,5,null =====> 1,3,5,2,4,null
 * https://leetcode.com/problems/odd-even-linked-list
 */
public class Odd_Even_Linked_List {

    public ListNode oddEvenLIst(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
