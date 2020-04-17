package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence
 */
public class Permutation_Sequence {

    public static void main(String[] args) {
        Permutation_Sequence entity = new Permutation_Sequence();
        entity.getPermutation(4, 9);
    }


    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        // store all the factorial numbers
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        // get all the factorial numbers all the way to n
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        System.out.println("factorial: " + Arrays.toString(factorial));
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        System.out.println("numbers:" + numbers);
        // numbers = {1, 2, 3, 4}

        // TODO: Why k--?
        k--;

        // following is the key part
        for(int i = 1; i <= n; i++) {
            // to get where we should start numbers
            int index = k/factorial[n-i]; // TODO: Why n-i?
            System.out.println("k:" + k);
            System.out.println("n-i:" + (n-i));
            System.out.println("index:" + index);
            sb.append(String.valueOf(numbers.get(index)));
            System.out.println("sb: " + sb.toString());
            numbers.remove(index);
            k = k - index*factorial[n-i];
        }

        return String.valueOf(sb);
    }

}
