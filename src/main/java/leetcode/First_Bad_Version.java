package leetcode;

/**
 * https://leetcode.com/problems/first-bad-version
 * 278. First Bad Version
 */
public class First_Bad_Version {
    boolean isBadVersion(int version) {
        if (version > 5) {
            return true;
        }
        return false;
    }

    /**
     * Binary search.
     * Example: 1,2,3,4 (3 is bad version)
     * loop 1: left = 0, right = 3, mid = 1
     * loop 2: left = 2, right = 3, mid = 2
     * loop 3: left = 2, right = 2 (then exit as left no longer smaller than right)
     * As left == right, the "left" is the first of bad version.
     * time: O(log n)
     * space: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int midpoint = left + (right - left) / 2;
            if (isBadVersion(midpoint)) {
                right = midpoint;
            } else {
                left = midpoint + 1;
            }
        }

        if (left == right && isBadVersion(left)) {
            return left;
        }

        return -1;
    }
}
