package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class Ugly_Number_II {
    public static void main(String[] args) {
        Ugly_Number_II entity = new Ugly_Number_II();
        entity.nthUglyNumber(18);
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        // int curr = 1;
        // int num = 2;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for(int i=1;i<n;i++){
            // min is the min number amony factor2, factor3 and factor5, which is actually the i'th number
            int min = Math.min(Math.min(factor2,factor3),factor5);
            dp[i] = min;
            Arrays.stream(dp).forEach(obj->System.out.print(obj + ","));
            System.out.println();
            if(factor2 == min) {
                index2++;
                factor2 = 2*dp[index2];
            }
            if(factor3 == min) {
                index3++;
                factor3 = 3*dp[index3];
            }
            if(factor5 == min) {
                index5++;
                factor5 = 5*dp[index5];
            }
            System.out.println("index2:" + index2 + ", index3:" + index3 + ", index5:" + index5 );
        }
        return dp[n-1];
    }
}
