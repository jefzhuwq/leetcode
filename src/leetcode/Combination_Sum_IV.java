package leetcode;

import utils.Utils;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class Combination_Sum_IV {
    public static void main(String [] args) {
        Combination_Sum_IV entity = new Combination_Sum_IV();
        int [] nums = {1,2,3};
        int target = 4;
        entity.combinationSum4(nums, target);
    }

    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        dp[0] = 1;
        for (int i=1;i<dp.length;i++) {
            for (int j=0;j<nums.length;j++) {
                System.out.println("i-nums[j]: " + (i-nums[j]));
                if (i-nums[j]>=0) { // need to consider 0 as if it's 0, means we need to add number into it
                    dp[i] += dp[i-nums[j]];
                }
                System.out.print("dp at j: " + j + " ");
                Utils.printArray(dp);
            }
        }
        return dp[target];
    }

}
