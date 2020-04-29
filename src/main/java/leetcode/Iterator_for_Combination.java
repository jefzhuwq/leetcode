package leetcode;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.com/problems/iterator-for-combination
 * 1286. Iterator for Combination
 */
public class Iterator_for_Combination {
    private String cur;
    private String str;
    private int l;

    /**
     * idea: light weight for constructor, using cur to keep the current status
     *
     * @param characters
     * @param combinationLength
     */
    public Iterator_for_Combination(final String characters, final int combinationLength) {
        cur = "";
        str = characters;
        l = combinationLength;
    }

    /**
     * idea: calculate the next variation based on cur.
     *
     * @return
     */
    public String next() {
        char[] charArray = cur.toCharArray();
//        System.out.println("cur:" + cur);
//        System.out.println("str:" + str);
        if (cur.length() == 0) {
            // if cur has nothing, means next() should be the very first string to return.
            // First "l" chars.
            charArray = str.substring(0, l).toCharArray();
//            System.out.println("cur.length=0, and charArray=" + new String(charArray));
        } else {
            int i = 0;
            // loop from last char in substring, to the beginning.
            for (i = l - 1; i >= 0; i--) {
//                System.out.println("i:" + i);
                if (charArray[i] != str.charAt(str.length() - (l - i))) {
//                    System.out.println("break");
                    break;
                }
            }

            int idx = str.indexOf(charArray[i]) + 1; // this will only work when the str has unique char

//            System.out.println("idx:" + idx);
//            System.out.println("Start loop i:" + i);
            for (; i < l; i++, idx++) {
//                System.out.println("Building charArray: " + new String(charArray));
                charArray[i] = str.charAt(idx);
            }
        }
        cur = new String(charArray);
        return cur;
    }

    /**
     * time: O(l) as we need to loop l times to find what's the current position of the variation, and if it has next or not.
     *
     * @return
     */
    public boolean hasNext() {
        if (cur.length() == 0) return true;
        for (int i = l - 1; i >= 0; i--) {
            if (cur.charAt(i) != str.charAt(str.length() - l + i)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        final String characters = "abc";
        final int combinationLength = 2;
        Iterator_for_Combination entity = new Iterator_for_Combination(characters, combinationLength);
        System.out.println(entity.next());
        System.out.println(entity.hasNext());
        System.out.println(entity.next());
    }
}
