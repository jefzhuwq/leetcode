package leetcode;

/**
 * https://leetcode.com/problems/ones-and-zeroes
 */
public class Ones_and_Zeroes {

    public static void main(String [] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        Ones_and_Zeroes entity = new Ones_and_Zeroes();
        System.out.println(entity.findMaxForm(strs, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] [] dp =new int [m+1][n+1];
//        int[][] temp = dp; // Question: Why we need temp here?

        for (int k=0;k<strs.length;k++) {
            int zeros = 0;
            int ones = 0;
            for (char c : strs[k].toCharArray()) {
                if (c == '0') zeros++;
                else if (c == '1') ones++;
            }

            System.out.println("str[]=" + strs[k]);
            System.out.println("zeros=" + zeros);
            System.out.println("ones=" + ones);


//            for (int i=zeros;i<=m;i++) {
//                for (int j=ones;j<=n;j++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
//                }
//            }

            for (int i=m;i>=zeros;i--) {
                for (int j=n;j>=ones;j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
//            dp = temp;
        }
        return dp[m][n];
    }
}
