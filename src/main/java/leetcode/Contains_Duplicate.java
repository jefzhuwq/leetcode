package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class Contains_Duplicate {

    /**
     * idea: HashSet, if any element pre-exist, then return true.
     * time: O(n)
     * space: O(n)
     * @param nums
     * @return
     */
    public boolean containDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i=0;i<nums.length;i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * idea: sort the array first and compare adjacent element they shouldn't be same.
     * time: O(n log n) as we do the sort first.
     * space: O(1) as we don't define any variable.
     * @param nums
     * @return
     */
    public boolean containDuplicate2(int [] nums) {
        Arrays.sort(nums);

        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
