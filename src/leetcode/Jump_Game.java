package leetcode;

/**
 * https://leetcode.com/problems/jump-game
 */
public class Jump_Game {
    public static void main(String[] args) {
        int[] input = {2,3,1,1,4};
        Jump_Game entity = new Jump_Game();
        System.out.println(entity.canJump(input));
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    // "position" means where to start jump
    public boolean canJumpFromPosition(int position, int[] nums) {
        System.out.println("Enter position: " + position);
        if (position == nums.length - 1) {
            System.out.println("Reach to last position, ready to return true");
            return true;
        }

        // pick position + steps from that position (and make sure furthest jump is within the length of array)
        int furthestJump = Math.min(position + nums[position], nums.length-1);
        System.out.println("Get furthestJump (index):" + furthestJump);
        // loop from next position to furthest jump, see if we could jump to furthest jump.
        for (int nextPosition = position + 1; nextPosition<=furthestJump;nextPosition++) {
            System.out.println("Start nextPotiion: " + nextPosition);
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
}
