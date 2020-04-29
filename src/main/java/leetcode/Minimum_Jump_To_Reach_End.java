package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of non-zero positive integers.
 * Each element in the array represents your maximum jump length at that position (means you could jump any steps within the range)
 * Find out what's the minimal jumps to reach to the end.
 */
public class Minimum_Jump_To_Reach_End {

    /**
     * idea: DP
     * 1. define an integer array to remember the min steps to jump to current position.
     * 2. loop input array, the current min would be min of
     * time: O(n^2) as we have outer loop and inner loop
     * space: O(n) as we define a dp array to store the current minimal step
     *
     * @param input
     * @return
     */
    public int solution(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        int[] minStepsList = new int[input.length];
        minStepsList[0] = 0;
        for (int i = 1; i < input.length; i++) {
            // from 0 to i
            for (int j = 0; j < i; j++) {
                // if j (current position) + max steps we can move from j >= i, which means we can reach to position i.
                if (j + input[j] >= i) {
                    // we need to update minstep value at position i if it's never set a value, or we see value at j + 1 < position i.
                    if (minStepsList[i] == 0 || minStepsList[j] + 1 < minStepsList[i]) {
                        // then set the position i
                        minStepsList[i] = minStepsList[j] + 1;
                    }
                }
            }
        }
//        Utils.printArray(minStepsList);
        return minStepsList[minStepsList.length - 1];
    }

    @Test
    public void test() {
        int[] input = new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        int expected = 4;
        assertEquals(expected, solution(input));
    }
}
