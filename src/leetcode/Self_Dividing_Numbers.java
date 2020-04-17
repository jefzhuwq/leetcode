package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers
 */
public class Self_Dividing_Numbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isSelfDividing(int num) {
        for (char c : String.valueOf(num).toCharArray()) {
            if (c == '0' || num % (c - '0') > 0) {
                return false;
            }
        }
        return true;
    }
}
