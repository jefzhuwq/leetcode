package leetcode;

import utils.Utils;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three
 */
public class Greatest_Sum_Divisible_By_Three {
    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        Greatest_Sum_Divisible_By_Three entity = new Greatest_Sum_Divisible_By_Three();
        System.out.println(entity.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[] {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        System.out.print("dp before for loop: ");
        Utils.printArray(dp);

        for (int a : nums) {
            int[] dp2 = new int[3];
            System.out.println("a: " + a);
            for (int i=0;i<3;i++) {
                dp2[(i+a)%3] = Math.max(dp[(i+a)%3], dp[i] + a);
                System.out.print("dp2: ");
                Utils.printArray(dp2);
            }
            dp = dp2;
            System.out.print("dp in loop: ");
            Utils.printArray(dp);
        }
        return dp[0];
    }

}
