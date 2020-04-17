package leetcode;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * S = "ab#c", T= "ad#c"
 */
public class Backspace_String_Compare {

//    public static void main(String[] args) {
//        String S = "ab#c";
//        String T = "#b#ad#c";
//
//        BackspaceStringCompare instance = new BackspaceStringCompare();
//        System.out.println(instance.backspaceCompare(S, T));
//    }

    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        }
        if (S == null || T == null) {
            return false;
        }
        // start from end of string
        int S_pointer = S.length() - 1;
        int T_pointer = T.length() - 1;
        int S_skips = 0;
        int T_skips = 0;


        // example ab#c
        // S_pointer = 3, S_skips = 0, T_pointer = 3, T_skips = 0, then compare the charAt(S_pointer) and charAt(T_pointer) => true
        while (S_pointer >= 0 || T_pointer >= 0) {

            // before loop: S_pointer = 2, S_skips = 0
            // in loop:
            //      S_pointer = 1, S_skips = 1
            //      S_pointer = 0, S_skips = 0
            //      then exit loop as current char is not "#" and S_skips == 0
            while (S_pointer >= 0) {
                if (S.charAt(S_pointer) == '#') { // if there's one #, then increment skips, and move pointer to previous position
                    S_skips += 1;
                    S_pointer -= 1;
                } else if (S_skips > 0) { // if there's one #, then increment skips, and move pointer to previous position
                    S_pointer -= 1;
                    S_skips -= 1;
                } else {
                    break;
                }
            }

            // same thing happen on T
            while (T_pointer >= 0) {
                if (T.charAt(T_pointer) == '#') {
                    T_skips += 1;
                    T_pointer -= 1;
                } else if (T_skips > 0) {
                    T_pointer -= 1;
                    T_skips -= 1;
                } else {
                    break;
                }
            }

            // if current char are not equal between S and T, then return false
            if (S_pointer >= 0 && T_pointer >= 0 && S.charAt(S_pointer) != T.charAt(T_pointer)) {
                return false;
            }

            // if there're still any char left (means length are not essentially the same), then return false;
            if ((S_pointer >= 0) != (T_pointer >= 0)) {
                return false;
            }

            // move both current pointer backwards
            S_pointer -= 1;
            T_pointer -= 1;
        }

        return true;


    }
}
