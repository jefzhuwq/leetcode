package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        int [] input = {3,2,1,5,6,4};
        int k = 2;
        Kth_Largest_Element_in_an_Array entity = new Kth_Largest_Element_in_an_Array();
        System.out.println(entity.findKthLargest(input, k));

    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
//        PriorityQueue<Integer> q = new PriorityQueue<>(k, new IntComparator());
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a,b) -> b - a);
        Arrays.stream(nums).forEach(num -> q.offer(num));
        int ret = q.poll();
        for (int i=0;i<k-1;i++) {
            ret = q.poll();
        }
       return ret;
    }

}
