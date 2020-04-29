package leetcode;

import org.junit.jupiter.api.Test;
import utils.Utils;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three
 * 1262. Greatest Sum Divisible by Three
 */
public class Greatest_Sum_Divisible_By_Three {

    /**
     * idea: dp, array with 3 elements can
     * time: O(n) as we pretty much need to traverse entire array
     * space: O(1) as we define 2 arrays with length of 3. (fixed length)
     *
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

//        System.out.print("dp before for loop: ");
//        Utils.printArray(dp);

        for (int a : nums) {
            int[] dp2 = new int[3];
            System.out.println("a: " + a);
            for (int i = 0; i < 3; i++) {
                // compare between (pre-exist remainder value) vs (pre-exist value + new value)
                // eg. dp2[(0+10)%3] = dp2[1] = max(dp[(0+10)%3], dp[0] + 10) = max(dp[1], dp[0] + 10)
                System.out.println(String.format("compare between: %s and %s, to put to position dp[%s]", dp[(i + a) % 3], (dp[i] + a), (i + a) % 3));
                dp2[(i + a) % 3] = Math.max(dp[(i + a) % 3], dp[i] + a);
                System.out.print("dp2: ");
                Utils.printArray(dp2);
            }
            dp = dp2;
            System.out.print("dp in loop: ");
            Utils.printArray(dp);
        }
        // final answer is the remainder is 0.
        return dp[0];
    }

    @Test
    public void test() {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivThree(nums));
    }
}
