package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height
 */
public class Queue_Reconstruction_by_Height {
    public static void main(String[] args) {
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Queue_Reconstruction_by_Height entity = new Queue_Reconstruction_by_Height();
        entity.reconstructQueue(input);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // first order by height, if same height ,order by number of taller people ahead of you
                return o1[0] != o2[0] ?  o2[0]- o1[0] : o1[1] - o2[1];
            }
        });

        print(people);
        List<int[]> ret = new LinkedList<>();

        for (int [] cur : people) {
            // because the array is sored by height, thus next element is guaranteed equal or shorter than previous one, thus using the second parameter as index. Smart idea
            ret.add(cur[1], cur);
        }
        return ret.toArray(new int[0][]);
    }

    public void print(int[][] input) {
        Arrays.stream(input).forEach(obj->System.out.print("[" + obj[0] + "," + obj[1] + "], "));
        System.out.println();
    }
}
