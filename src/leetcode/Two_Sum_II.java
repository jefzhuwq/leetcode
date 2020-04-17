package leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int a_p = 0;
        int b_p = numbers.length - 1;

        while (a_p <= b_p) {
            int sum = numbers[a_p] + numbers[b_p];
            if (sum > target) {
                b_p--;
            } else if (sum < target) {
                a_p++;
            } else {
                return new int[]{a_p + 1, b_p + 1
                };
            }
        }
        return new int[]{
                a_p + 1, b_p + 1
        };

    }
}
