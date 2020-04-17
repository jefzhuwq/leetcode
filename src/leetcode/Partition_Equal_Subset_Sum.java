package leetcode;

import utils.Utils;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum
 */
public class Partition_Equal_Subset_Sum {

    public static void main(String[] args) {
        int [] nums = {1,5,11,5};
        Partition_Equal_Subset_Sum entity = new Partition_Equal_Subset_Sum();
        System.out.println(entity.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        // get what's the half number (if odd, directly return)
        //sort
        //loop from 0-nums
        // if
        int sum = Arrays.stream(nums).sum();
        if (sum%2!=0) {
            return false;
        } else {
            sum = sum/2;
        }

        Arrays.sort(nums);
        boolean[][] dp = new boolean[nums.length][sum+1];
        Utils.printArray(dp[1]);
        for (int i=0;i<nums.length;i++) {
            for (int s=1;s<=sum;s++) {
                if (i==0) {
                    dp[i][s] = (s-nums[i]==0);
                } else {
                    if (s-nums[i]<0) {
                        dp[i][s] = dp[i-1][s];
                    } else if (s-nums[i]==0 || dp[i-1][s] || dp[i-1][s-nums[i]]) {
                        dp[i][s] = true;
                    } else {
                        dp[i][s] = false;
                    }
                }
            }
            Utils.printArray(dp[i]);
            if (dp[i][sum]) {
                return true;
            }
        }
        return false;
    }
}
