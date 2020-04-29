package leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * 703. Kth Largest Element in a Stream
 */
public class Kth_Largest_Element_in_a_Stream {

    final int k;
    public final PriorityQueue<Integer> q;

    /**
     * time: O(n log n) as we loop every element in nums, and each add to priority queue is (log n)
     * space: O(k) as we defined a priority queue with k size.
     *
     */
    public Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        q = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * time: O(log n) , every time add to priority queue, time is log n
     * space: O(1)
     *
     * @param val
     * @return
     */
    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) { // because if val<=q.peek() and we don't have capacity (size is larger than k), we actually don't care (peek means the first element, which is the smallest)
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    @Test
    public void test() {
        Kth_Largest_Element_in_a_Stream entity = new Kth_Largest_Element_in_a_Stream(3, new int[]{4, 5, 8, 2});
        System.out.println(entity.add(3));
        System.out.println(entity.add(5));
        System.out.println(entity.add(10));
        System.out.println(entity.add(9));
        System.out.println(entity.add(4));

        System.out.println("poll q");
        while (!entity.q.isEmpty()) {
            System.out.println(entity.q.poll());
        }
    }
}
