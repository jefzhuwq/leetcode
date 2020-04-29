package leetcode;

import org.junit.jupiter.api.Test;
import utils.Utils;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * 377. Combination Sum IV
 */
public class Combination_Sum_IV {

    /**
     * idea: DP, bottom-up, the reason is we don't have to output the actual result, but just the count of combinations
     *      1. define a dp array to store count of combination which sum is target - current number.
     *      2. dp[0] is 1: means
     * time: O(target * n) as we have 2 embedded loop, outer is target times, inner is nums length
     * space: O(target) as we define an array with amount of "target" elements
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // loop from 1 to target number
        for (int i = 1; i < dp.length; i++) {
            // loop from 0 to end of nums
            for (int j = 0; j < nums.length; j++) {
                System.out.println("i=" + i + ", nums[j]=" + nums[j]);
                System.out.println("i-nums[j]: " + (i-nums[j]));
                if (i - nums[j] >= 0) { // need to consider 0 as if it's 0, means we need to add number into it
                    dp[i] += dp[i - nums[j]];
                }
                System.out.print("dp at j: " + j + ":");
                Utils.printArray(dp);
            }
        }
        return dp[target];
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

}
