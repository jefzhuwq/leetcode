package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class Combination_Sum_III {
    public static void main(String[] args) {
        Combination_Sum_III entity = new Combination_Sum_III();
        System.out.println(entity.combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        help(n, k, 1, ret, new ArrayList<Integer>());
        return ret;
    }

    public void help(int n, int k, int start, List<List<Integer>> ret, List<Integer> row) {
        if (n<0 || row.size()>k) {
            return;
        }
        if (n ==0 && row.size()==k) {
            ret.add(new ArrayList<Integer>(row));
            return;
        }
        for (int i=start;i<=n;i++) {
            row.add(i);
            help(n-i, k, i+1, ret, row);
            row.remove(row.size()-1);
        }
    }
}
