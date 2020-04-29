package leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 * 287. Find the Duplicate Number
 */
public class Find_the_Duplicate_Number {

    /**
     * idea: Floyd's Tortoise and Hare (Cycle Detection)
     * time: O(n)
     * space: O(1)
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // corner case check
        if (nums.length == 0) {
            return 0;
        }
        // slow and fast start from first number
        int slow = nums[0];
        int fast = nums[0];

        do {
            // slow points to number index based on previous value of slow
            slow = nums[slow];
            // fast points twice
            fast = nums[nums[fast]];
        } while (slow != fast); // until

        // reset fast to first element
        fast = nums[0];

        // loop that again, when the next time they meet each other is the duplicate number
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
