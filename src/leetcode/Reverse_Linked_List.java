package leetcode;

import ds.ListNode;

public class Reverse_Linked_List {
    /**
     * 1->2->3->4->5->null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

}
