package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
 */
public class The_K_Weakest_Rows_in_Matrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int [] rows = new int [mat.length];
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[0].length;j++) {
                if (mat[i][j]!=0) {
                    rows[i]++;
                } else {
                    break;
                }
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i=0;i<rows.length;i++) {
            q.offer(rows[i]);
            if (q.size()>k) {
                q.poll();
            }
        }
        return Arrays.stream(q.toArray(new Integer[k])).mapToInt(Integer::intValue).toArray();
    }
}
