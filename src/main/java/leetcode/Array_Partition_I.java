package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 * 561. Array Partition I
 */
public class Array_Partition_I {
    /**
     * idea:
     *      1. sort input array
     *      2. loop array and always find the prior item (the prior item should always be smaller)
     * time: O(n + n log n), which is O(n log n) as we iterate length of nums.
     * space: O(1) as we only define constant variable.
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    /**
     * idea:
     *      1. sort
     *      2. loop from 0 to half size of array, in each loop, get min between 2*i and 2*i+1.
     * time: O(n + n log n), which is O(n log n) as we iterate length of nums.
     * space: O(1) as we only define constant variable.
     *
     * @param nums
     * @return
     */
    public int arrayPairSum2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int globalMin = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            globalMin += Math.min(nums[2 * i], nums[2 * i + 1]);
        }
        return globalMin;
    }
}
