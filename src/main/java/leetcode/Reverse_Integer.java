package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer
 */
public class Reverse_Integer {

    /**
     * Some example:
     * 123 to 321
     * -123 to -321
     * @param x
     * @return
     */
    public int reverse(int x) {
        int reversed = 0;
        int pop;

        while (x != 0) {
            // the way pop being calculated already consider negative number, for example, 123 % 10 = 13, -123 % 10 = -3
            pop = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || reversed == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || reversed == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }

            reversed = reversed * 10 + pop;
        }

        return reversed;
    }
}
