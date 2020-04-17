package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class Contains_Duplicate {

    public boolean containDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int i=0;i<nums.length;i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }
        }
        return false;
    }


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
