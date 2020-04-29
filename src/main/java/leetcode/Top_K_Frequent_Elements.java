package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = {1,1,3,1,2,2};
        Top_K_Frequent_Elements entity = new Top_K_Frequent_Elements();
        System.out.println(entity.topKFrequent(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length ==0) {
            return ret;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // init heap 'the less frequent element first', which means when poll the queue, smaller number will be polled out
        // the PriorityQueue is using a customized comparitor, in this case, it's using map defined within the same function
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        System.out.println("heap size: " + heap.size());

        for (Integer key : map.keySet()) {
            heap.add(key);
            // poll when heap has more items than we need, this way keeps heap the same size as k (and prevent it growing)
            if (heap.size()>k) {
                int polledValue = heap.poll();
                System.out.println("polled value: " + polledValue);
            }
        }

        // build output list
        while (!heap.isEmpty()) {
            ret.add(heap.poll());
        }

        // Collections.reverse(ret);
        return ret;
    }
}
