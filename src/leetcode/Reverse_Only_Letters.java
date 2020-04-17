package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-only-letters
 */
public class Reverse_Only_Letters {
    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                letters.push(S.charAt(i));
            }
        }

        StringBuilder reversed_string = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                reversed_string.append(letters.pop());
            } else {
                reversed_string.append(S.charAt(i));
            }
        }

        return reversed_string.toString();
    }

    public String reverseOnlyLetters2(String S) {
        StringBuilder reversed_string = new StringBuilder();
        int j = S.length() - 1;

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                reversed_string.append(S.charAt(j));
                j--;
            } else {
                reversed_string.append(S.charAt(i));
            }
        }

        return reversed_string.toString();
    }
}
