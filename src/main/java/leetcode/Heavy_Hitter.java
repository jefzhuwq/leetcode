package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Get top k top hitters by a given events
 */
public class Heavy_Hitter {

    class HeavyHitter {

        private final String identifier;
        private final int frequency;

        public HeavyHitter(String identifier, int frequency) {
            this.identifier = identifier;
            this.frequency = frequency;
        }

        public int getFrequency() {
            return this.frequency;
        }
    }

    /**
     * idea: priority queue, it's basically the heap.
     * time: O(n * log n) as we loop every element in events array, and also adding to priority queue is (log n)
     * space: O(k) as we define queue with k size.
     *
     * @param events
     * @param k
     * @return
     */
    public List<HeavyHitter> topK(String[] events, int k) {
        Map<String, Integer> frequencyTable = new HashMap<>();
        for (String event : events) {
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        // priority is based on frequency.
        PriorityQueue<HeavyHitter> heap = new PriorityQueue<>(Comparator.comparing(e -> e.getFrequency()));

        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            heap.offer(new HeavyHitter(entry.getKey(), entry.getValue()));

            // keep polling (remove) items if total size is more than k
            // please remember the poll is removing the first element (which means the smallest element will be removed, not the larger ones)
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // poll (move) everything to final list
        List<HeavyHitter> result = new ArrayList<>();
        while (heap.size() > 0) {
            result.add(heap.poll());
        }

        return result;
    }

    @Test
    public void test() {
        String[] events = new String[]{"1", "2", "3", "4", "5", "6", "2", "3", "4", "1", "3"};
        int k = 3;
        List<HeavyHitter> list = this.topK(events, k);
        list.stream().forEach(o-> System.out.println(o.identifier + ":" + o.frequency));
    }
}
