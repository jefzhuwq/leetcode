package leetcode;

/**
 * https://leetcode.com/problems/jewels-and-stones
 */
public class Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        int num_jewels = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1) {
                num_jewels++;
            }
        }
        return num_jewels;
    }
}
