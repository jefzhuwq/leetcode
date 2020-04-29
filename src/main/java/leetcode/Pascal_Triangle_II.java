package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii
 */
public class Pascal_Triangle_II {
    public static void main(String[] args) {
        Pascal_Triangle_II entity = new Pascal_Triangle_II();
        System.out.println(entity.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i=1;i<=rowIndex;i++) {
            for (int j=i-1;j>=1;j--) {
                int tmp = row.get(j - 1) + row.get(j);
                row.set(j, tmp); // using set so that we don't have to worry about the add elements.
            }
            row.add(1);

            System.out.println(row);
        }
        return row;
    }

}
