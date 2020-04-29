package leetcode;

/**
 * https://leetcode.com/problems/sort-array-by-parity
 */
public class Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        int[] new_arr = new int[A.length];
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                new_arr[counter] = A[i];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                new_arr[counter] = A[i];
                counter++;
            }
        }
        return new_arr;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

            if (A[i] % 2 == 0) {
                i++;
            }

            if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }
}