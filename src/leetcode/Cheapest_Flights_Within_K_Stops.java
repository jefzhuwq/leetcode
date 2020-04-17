package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class Cheapest_Flights_Within_K_Stops {

    public int solution(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new HashMap<Integer, Integer>());
            }
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>();
        // 0 price,
        pq.add(new int[] {0, src, K+1});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            if (city == dst) return price;
            int stops = top[2];
            if (stops>0) {
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops-1});
                }
            }
        }
        return -1;
    }
}
