package leetcode;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array
 */
public class Squares_of_A_Sorted_Array {
    public int [] sortedSquares(int[] A) {
        int N = A.length;
        int positive_pointer = 0;
        while (positive_pointer < N ) {
            positive_pointer ++;
        }
        int negative_pointer = positive_pointer - 1;

        // the array will be returned
        int [] sorted_squares = new int[N];
        // global counter
        int counter = 0;

        while (negative_pointer>=0 && positive_pointer<N) {
            if (A[negative_pointer] * A[negative_pointer] < A[positive_pointer] * A[positive_pointer]) {
                sorted_squares[counter] = A[negative_pointer] * A[negative_pointer];
            } else {
                sorted_squares [ counter] = A[positive_pointer] * A[positive_pointer];
                positive_pointer ++;
            }

            counter ++;
        }

        while (negative_pointer >=0) {
            sorted_squares[counter] = A[negative_pointer] * A[negative_pointer];
            negative_pointer --;
            counter ++;
        }

        while (positive_pointer <N) {
            sorted_squares[counter] = A[positive_pointer] * A[positive_pointer];
            positive_pointer ++;
            counter ++;
        }

        return sorted_squares;
    }
}
