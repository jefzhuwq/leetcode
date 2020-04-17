package leetcode;

import utils.Utils;

public class Minimum_Jump_To_Reach_End {
    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        Minimum_Jump_To_Reach_End entity = new Minimum_Jump_To_Reach_End();
        System.out.println(entity.solution(input));
    }


    public int solution(int[] input) {
        if (input.length == 0) {
            return 0;
        }
//        int[] lastIndexList = new int[input.length];
        Integer[] minStepsList = new Integer[input.length];
//        lastIndexList[0] = 0;
        minStepsList[0] = 0;
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + input[j] >= i) {
                    if (minStepsList[i] == 0 || minStepsList[j] + 1 < minStepsList[i]) {
                        minStepsList[i] = minStepsList[j] + 1;
//                        lastIndexList[i] = j;
                    }
                }
            }
        }
//        printArray(lastIndexList);
        Utils.printArray(minStepsList);
        return minStepsList[minStepsList.length - 1];
    }
}
