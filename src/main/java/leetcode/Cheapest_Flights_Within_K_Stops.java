package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 787. Cheapest Flights Within K Stops
 */
public class Cheapest_Flights_Within_K_Stops {

    /**
     * idea: DP, Dijkstra's
     * time: O()
     * space: O()
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int solution(int n, int[][] flights, int src, int dst, int K) {
        // first creates graph from flights data
        // key is src, value is dst and cost
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new HashMap<>());
            }
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        // queue is to store cost, src, and number of remaining stops
        Queue<int[]> pq = new PriorityQueue<>();
        // 0 price, 1 src, 2 number of remaining stops
        pq.add(new int[]{0, src, K + 1});

        while (!pq.isEmpty()) {
            // get top path in priority queue (shortest )
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            // if we already see the city same as dst, means we found the path.
            if (city == dst) return price;
            int stops = top[2];
            // means if we are still within k stops
            if (stops > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
