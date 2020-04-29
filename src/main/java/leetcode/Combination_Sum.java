package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 39. Combination Sum
 */
public class Combination_Sum {

    /**
     * idea: backtracking, recursive
     * it's a combination problem instead of permutation (means order doesn't matter)
     * 1. sort array
     * 2. call helper function
     * time: O(n!) as execution is in this way: n(n-1)(n-2)(n-3)....(n-k)
     * space: O(n*m) as we define a List of an integer List
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates.length == 0) {
            return ret;
        }
        Arrays.sort(candidates);
//        Arrays.stream(candidates).forEach(obj-> System.out.print(obj + ", "));
        help(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    /**
     * 1. check remain
     *      if negative, means it doesn't fit
     *      if 0, means it's the candidate list (add tempList to final result)
     *      else, we should loop from start index to end of array
     * @param list final result
     * @param tempList current row
     * @param nums input array
     * @param remain remaining number
     * @param start start index
     */
    public void help(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) { // means it doesn't fit, no answer, directly return
            return;
        } else if (remain == 0) { // means it has answer, add tempList to final result
            list.add(new ArrayList<>(tempList));
        } else {
            // loop from start to last digit as we want to build tree using different root node (depends on the number on current location)
            for (int i = start; i < nums.length; i++) {
                // this means current number is duplicate than previous one,
                // we can't use the duplicate one given the requirement has "(without duplicates)"
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                help(list, tempList, nums, remain - nums[i], i + 1);
                // after backtracking, need to remove recent added item from tempList.  No matter you find answer or not.
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum(input, target));
    }
}
