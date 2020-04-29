package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 216. Combination Sum III
 */
public class Combination_Sum_III {

    /**
     * idea: backtracking, recursive
     *
     * time:
     * space:
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(final int k, final int n) {
        List<List<Integer>> ret = new ArrayList<>();
        help(n, k, 1, ret, new ArrayList<>());
        return ret;
    }

    /**
     *
     * @param n target sum
     * @param k target count of numbers
     * @param start start index, every time we should start loop from a new index as we can't re-pick the same item at same position
     * @param ret
     * @param row
     */
    public void help(final int n, final int k, final int start, final List<List<Integer>> ret, final List<Integer> row) {
        // if negative or count of numbers are larger than k, means we enter invalid state.
        if (n < 0 || row.size() > k) {
            return;
        }
        // sum are the same, and count of numbers are same as k, means it should be added to final result
        if (n == 0 && row.size() == k) {
            ret.add(new ArrayList<>(row));
            return;
        }
        // loop from start to n (target number)
        for (int i = start; i <= n; i++) {
            // add current number to row
            row.add(i);
            // recursively call helper function. Pay attention that start index increment by 1 as we can't re-use the same number in next level of recursion
            help(n - i, k, i + 1, ret, row);
            // remove last item added, and then move on (try next number).
            // from the tree perspective, (in order to reuse the same structure) it's go back to parent node by removing the current node from list
            row.remove(row.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 7));
    }
}
