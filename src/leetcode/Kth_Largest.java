package leetcode;

import java.util.PriorityQueue;

public class Kth_Largest {
    // it seems using priority queue would be the best, and sort in descending order
    final int k;
    public final PriorityQueue<Integer> q;

    // space is O(k) as we defined a priority queue with k size.
    public Kth_Largest(int k, int[] nums) {
        q = new PriorityQueue<>(k);
//        q = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
//            q.add(num);
//            System.out.println("q.peek: " + q.peek());
        }
    }



    // time:
    // space: O(1)
    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) { // because if val<=q.peek(), we actually don't care
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        Kth_Largest entity = new Kth_Largest(3, new int[] {4,5,8,2});
//        entity.q.peek();
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
