package leetcode;

import ds.ListNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class Swap_Nodes_In_Pair {
    public static void main(String[] args) {
        Swap_Nodes_In_Pair entity = new Swap_Nodes_In_Pair();
        ListNode head = entity.constructList();
        Utils.printList(entity.swapPairs(head));

    }

    public ListNode constructList() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
        return head;
    }
    // 1->2->3->4
    // WARNING: the code is buggy as there's no prior node before the pair, thus we can't redirect previous pair to the new pair.
    // KEEP IN MIND
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode newHead = head.next;
        while (curr!=null) { // second time curr = 3
            ListNode tmp = curr.next.next; // tmp = null here
            // curr.next = 4, curr.next.next = null;
            curr.next.next = curr; // curr.next.next = 3
            curr.next = tmp; // curr.next = null
            curr = tmp; // curr = null
            Utils.printList(newHead);
        }
        return newHead;
    }
}
