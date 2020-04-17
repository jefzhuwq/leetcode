package leetcode;

import java.util.*;

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

    public static void main(String[] args) {
        Heavy_Hitter main = new Heavy_Hitter();
//        this.topK()
    }

    public List<HeavyHitter> topK(String[] events, int k) {
        Map<String, Integer> frequencyTable = new HashMap<>();
        for (String event : events) {
            frequencyTable.put(event, frequencyTable.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> heap = new PriorityQueue<>(Comparator.comparing(e -> e.getFrequency()));

        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            heap.offer(new HeavyHitter(entry.getKey(), entry.getValue()));

            if (heap.size() > k) {
                heap.poll();
            }

        }

        List<HeavyHitter> result = new ArrayList<>();
        while (heap.size() > 0) {
            result.add(heap.poll());
        }

        return result;
    }

}
