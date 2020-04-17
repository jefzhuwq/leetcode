package leetcode;

import utils.Utils;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum
 */
public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] A = {{-19,57}, {-40,-5}};
        Minimum_Falling_Path_Sum entity = new Minimum_Falling_Path_Sum();
        System.out.println(entity.minFallingPathSum(A));
    }

    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int dp[] = new int[A[0].length + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i=0;i<A[0].length;i++) {
            dp[i+1] = A[0][i];
        }

        for (int r=1;r<A.length;r++) {
            int[] dp2 = dp.clone();
            for (int c=0;c<A[0].length;c++) {
                Utils.printArray(dp);
                dp2[c+1] = Math.min(dp[c], Math.min(dp[c+1], dp[c+2])) + A[r][c];
            }
            System.out.print("dp2: ");
            Utils.printArray(dp2);
            dp = dp2;
        }
        System.out.print("dp after: ");
        Utils.printArray(dp);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<dp.length;i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
