package leetcode;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] results = new int[A.length];

        int counter = 0;
        int current_sum = 0;

        while (counter < results.length) {

            int val = queries[counter][0];

            int index = queries[counter][1];

            A[index] += val;

            for (int  i=0;i<A.length;i++) {
                if (A[i]%2 == 0) {
                    current_sum += A[i];
                }
            }


            results[counter] = current_sum;
            counter++;
            current_sum = 0;
        }
        return results;
    }
}
