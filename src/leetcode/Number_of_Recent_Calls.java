package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls
 */
public class Number_of_Recent_Calls {
    private class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);

            while (queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }
}
