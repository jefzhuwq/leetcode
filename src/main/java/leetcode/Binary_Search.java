package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a sorted integer array and target integer, find the index of the target, return -1 if not found.
 * Make sure time is O(log n)
 */
public class Binary_Search {

    /**
     * idea: have two pointers, left and right, use these two pointers to calculate the mid.
     * until left converging with right, there will be 3 possible results each time compare:
     *      1. equal, means found result, return.
     *      2. mid is larger than target, means target is on the left side, then right=mid-1
     *      3. mid is smaller than target, means target is on the right side, right left = mid+1
     * Remember binary search can only apply when it's an sorted array (if it's a tree, then it should be a search tree)
     * time: O(log n) as we apply binary search, every time we eliminate half of the rest array.
     * space: O(1) as we only define two integers as pointer purpose.
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (nums[midpoint] > target) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int [] nums = new int[] {1,2,3,4,5,6};
        int target = 2;
        assertEquals(1, search(nums, target));
    }
}
