package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack_Problem {
    // the input, every single element input input[i], first element is value, second is weight
    public int solution(int[][] input, int maxWeight) {
        int[][] dp = new int[input.length][maxWeight + 1];
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < input.length; i++) {
            for (int w = 1; w < maxWeight + 1; i++) {
                if (i==0) {
                    if (w - input[i][1] <0) {
                        dp[i][w] = 0;
                    } else {
                        dp[i][w] = input[i][0];
                    }
                } else {
                    if (w - input[i][1] < 0) {
                        dp[i][w] = dp[i-1][w];
                    } else {
                        dp[i][w] = Math.max(dp[i-1][w-input[i][1]] + input[i][0], dp[i-1][w]);
                    }
                }
            }
        }
        return dp[input.length-1][maxWeight];
    }

    public int maxCoins(int[] nums) {
        int[] fullNums = new int[nums.length +2];
        fullNums[0] = 1;
        fullNums[nums.length+1] = 1;
        int [][]store = new int[fullNums.length][fullNums.length];
        Arrays.stream(store).forEach(obj-> Arrays.fill(obj, -1));
        //        for (int i=1;i<fullNums.length;++i) {
//            for (int j=1;j<fullNums.length;i++) {
//                store[i][j] = -1;
//            }
//        }
        return getStore(1, fullNums.length-2, store, fullNums);
    }

    // from being to end, burst balloon, store in the store array, in fullNums
    private int getStore(int begin, int end, int[][]store, int[] fullNums) {
        if (begin>end) return 0; // no balloon allows me to burst in this case.
        if (store[begin][end]!=-1) { // there's existing value
            return store[begin][end];
        }
        for (int pos=begin; pos<=end;++pos) {
            int leftCoin = getStore(begin, pos-1, store, fullNums);
            int midCoin = fullNums[begin -1] * fullNums[pos] * fullNums[end+1];
            int rightCoin = getStore(pos+1, end, store, fullNums);
            int coin = leftCoin + midCoin + rightCoin;
            if (coin> store[begin][end]) {
                store[begin][end] = coin;
            }
        }
        return store[begin][end];
    }
}
