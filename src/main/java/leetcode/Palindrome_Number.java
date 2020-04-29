package leetcode;

/**
 * https://leetcode.com/problems/palindrome-number
 */
public class Palindrome_Number {

    /**
     * Check if integer number is palindrome
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        // 0 is palindrome
        if (x == 0) {
            return true;
        }
        // negative number (-121) is not palindrome
        // also
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        // create a new integer for half of reversed number
        // (eg. in 123321, we want the reversed_int=123
        // (another example is in 12321, reversed_int=12)
        int reversed_int = 0;

        // each time move one digit a time
        // x = 123321, reversed_int = 0
        // x = 12332, reversed_int = 1
        // x = 1233, reversed_int = 12
        // x = 123, reversed_int = 123
        // exit loop as x is no longer larger than reversed_int

        // another example: x=12321, reversed_int = 0
        // x = 12321, reversed_int = 0
        // x = 1232, reversed_int = 1
        // x = 123, reversed_int = 12
        // x = 12, reversed_int = 123
        // exit loop as x is no longer larger than reversed_int
        while (x > reversed_int) {
            int pop = x % 10;
            x /= 10;
            reversed_int = (reversed_int * 10) + pop;
        }

        // check if x is equal to reversed_int,
        // or in the odd number of digits, you need to remove last digit in reversed_int before comparison
        if (x == reversed_int || x == reversed_int / 10) {
            return true;
        } else {
            return false;
        }
    }
}
