package leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 */
public class Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int slow_pointer = nums[0];
        int fast_pointer = nums[0];

        slow_pointer = nums[slow_pointer];
        fast_pointer = nums[nums[fast_pointer]];

        while (slow_pointer != fast_pointer) {
            slow_pointer = nums[slow_pointer];
            fast_pointer = nums[nums[fast_pointer]];
        }
        int a_pointer = nums[0];
        int b_pointer = slow_pointer;

        while (a_pointer != b_pointer) {
            a_pointer = nums[a_pointer];
            b_pointer = nums[b_pointer];
        }
        return a_pointer;
    }
}
