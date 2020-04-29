package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        Triangle entity = new Triangle();
        System.out.println(entity.minimumTotal(triangle));
    }

    // dp solution
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp array which stores the min value when stay at the current value (inclusive)
        int[] dp = new int[triangle.size()+1];
        // loop from last row
        for(int i=triangle.size()-1;i>=0;i--) {
            System.out.println("i=" + i);
            // loop the column from 0 to last column
            for(int j=0;j<triangle.get(i).size();j++) {
                // the min is between j and j+1
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                System.out.println("j=" + j + ", dp[j]=" + dp[j]);
            }
        }
        return dp[0];
    }
}
