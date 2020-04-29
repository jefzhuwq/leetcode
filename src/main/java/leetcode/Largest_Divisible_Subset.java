package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset
 */
public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        Largest_Divisible_Subset entity = new Largest_Divisible_Subset();
        int [] nums = {1,2,4,8};
        System.out.println(entity.largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n]; // store count of subset
        int[] pre = new int[n]; // pre is from the current index, what's the previous index of the number? (-1 means there's no previous number should be included in final result)
        Arrays.sort(nums);
        int max = 0; // current max size of subset
        int index = -1;
        for (int i = 0; i < n; i++) {
            System.out.println("i:" + i);
            count[i] = 1; // include itself, thus smallest count[i] is 1
            pre[i] = -1; //

            System.out.print("Before inner loop pre[]:");
            Arrays.stream(pre).forEach(obj->System.out.print(obj + ","));
            System.out.println();

            System.out.print("Before inner loop count[]:");
            Arrays.stream(count).forEach(obj->System.out.print(obj + ","));
            System.out.println();

            for (int j = i - 1; j >= 0; j--) { //loop from i-1 to 0
                if (nums[i] % nums[j] == 0) { // if nums[i] can be divided by nums[j] and also count[j]+1 > count[i]
                    if (1 + count[j] > count[i]) { // only when we see the count
                        count[i] = count[j] + 1; // increment count[i]
                        pre[i] = j;
                    }
                }
            }
            System.out.print("After inner loop pre[]:");
            Arrays.stream(pre).forEach(obj->System.out.print(obj + ","));
            System.out.println();

            System.out.print("After inner loop count[]:");
            Arrays.stream(count).forEach(obj->System.out.print(obj + ","));
            System.out.println();

            if (count[i] > max) {
                max = count[i]; // update current max
                index = i; //
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
