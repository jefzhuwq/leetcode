package leetcode;

/**
 * https://leetcode.com/problems/number-of-islands
 */
public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBSF(grid, i, j);
                }
            }
        }
        return count;
    }

    public void callBSF(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        callBSF(grid, i + 1, j); // up
        callBSF(grid, i - 1, j); // down
        callBSF(grid, i, j - 1); // left
        callBSF(grid, i, j + 1); // right
    }
}
