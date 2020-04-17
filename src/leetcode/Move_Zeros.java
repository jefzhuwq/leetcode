package leetcode;

/**
 * https://leetcode.com/problems/move-zeroes
 */
public class Move_Zeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos] = num;
                this.printLine(nums);
                insertPos++;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int [] nums = {0,1,0,3,12};
        Move_Zeros instance = new Move_Zeros();

        System.out.print("Before: ");
        instance.printLine(nums);

        instance.moveZeroes(nums);

        System.out.print("After: ");
        instance.printLine(nums);
    }

    public void printLine(int[] nums) {
        System.out.print("[");
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println("]");
    }
}
