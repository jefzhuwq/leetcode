package leetcode;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/decode-ways
 * 91. Decode Ways
 */
public class Decode_Ways {

    /**
     * idea: dp, bottom up
     * we could think of that under certain criteria, the dp[i] = dp[i-1] + dp[i-2] (depends on what's the value on i-1 and i-2)
     * time: O(n) as we loop array once
     * space: O(n) as we define the dp array
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        String s = "126";
        System.out.println(numDecodings(s));
    }
}
