package utils;

import ds.ListNode;

import java.util.Arrays;

public class Utils {

    public static <T> void printArray(T[] input) {
        Arrays.stream(input).forEach(obj-> System.out.print(obj + ", "));
        System.out.println();
    }

    public static void printArray(int[] input) {
        Arrays.stream(input).forEach(obj-> System.out.print(obj + ", "));
        System.out.println();
    }

    public static void printArray(boolean[] input) {
        for (int i=0;i<input.length;i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println();
    }

    public static void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println();
    }
}
