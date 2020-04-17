package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
