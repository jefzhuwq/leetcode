package leetcode;

/**
 * https://leetcode.com/problems/to-lower-case/
 * This is low priority
 */
public class To_Lower_Case {
    public String toLower(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // why is 32? Because same letter + 32 is lower case.
                result = result + (char) (c + 32);
            } else {
                result = result + c;
            }
        }
        return result;
    }
}
