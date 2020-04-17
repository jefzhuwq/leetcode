package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Combination_Sum {
    public static void main(String[] args) {
        int [] input = {10,1,2,7,6,1,5};
        int target = 8;
        Combination_Sum entity = new Combination_Sum();
        System.out.println(entity.combinationSum(input, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates.length==0) {
            return ret;
        }
        Arrays.sort(candidates);
        Arrays.stream(candidates).forEach(obj-> System.out.print(obj + ", "));
        System.out.println();
        help(ret, new ArrayList<Integer>(), candidates, target, 0);
        return ret;
    }

    public void help(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
        System.out.println("call with start: " + start);
        if(remain < 0) { // means it doesn't fit, no answer, directly return
            System.out.println("==========end as remain is negative==============");
            return;
        } else if(remain == 0) { // means it has answer, add tempList to final result
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i=start;i<nums.length;i++) {
                System.out.println("i=" + i + ", start=" + start);
                if (i>start && nums[i] == nums[i-1]) {
                    System.out.println("continue as nums[i]=" + nums[i] + ", and nums[i-1]=" + nums[i-1]);
                    continue;
                }
                System.out.println("add nums at index: " + i );
                tempList.add(nums[i]);
                System.out.println("tempList: " + tempList);
                help(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1); // after backtracking, need to remove recent added item from tempList.  No matter you find answer or not.
            }
        }
        System.out.println("==========end==============");
    }
}
