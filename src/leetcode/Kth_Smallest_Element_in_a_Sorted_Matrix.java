package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix {
    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_Sorted_Matrix entity = new Kth_Smallest_Element_in_a_Sorted_Matrix();
        int [][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(entity.kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {

            int mid = lo + (hi - lo) / 2;
            System.out.println("mid:" + mid);
            // count is reset to 0 everytime
            int count = 0,  j = matrix[0].length - 1;

            // this loop is from top to bottom, find out each row how many items smaller than mid.
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    System.out.println("matrix[i][j]:" + matrix[i][j]);
                    j--;
                }
                System.out.println("count:" + count + ", j:" + j);
                count += (j + 1);
            }
            System.out.println("count:" + count);
            // compare to the number of items smaller than k, if it's been
            if(count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
