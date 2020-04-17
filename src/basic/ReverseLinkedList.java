package basic;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        int[] arr = {1, 2, 3, 4, 5};

        // original order
        ListNode head = solution.constructLinkedList(arr);
        solution.printLinkedList(head);

        // reverse iteratively
        head = solution.reverseIterative(head);
        solution.printLinkedList(head);

        // reverse recursively
        head = solution.reverseRecursive(head);
        solution.printLinkedList(head);
    }

    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode constructLinkedList(int[] arr) {

        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public ListNode reverseIterative(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseIterative(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
