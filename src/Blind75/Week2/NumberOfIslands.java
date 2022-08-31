package Blind75.Week2;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 16656 👎 383

import java.util.LinkedList;

public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    this.dfs(grid, i, j);
                    result++;
                    //System.out.println(Arrays.deepToString(grid));
                }
            }
        }

        return result;
    }

    private boolean bfs(char[][] grid, int x, int y) {
        LinkedList<int[]> queue = new LinkedList<>();
        grid[x][y] = '#';
        queue.add(new int[]{x, y});
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (queue.size() > 0) {
            int[] xAndY = queue.pollFirst();
            int xx = xAndY[0];
            int yy = xAndY[1];

            for (int[] direct : direction) {
                int _x = xx + direct[0];
                int _y = yy + direct[1];

                if (_x >= 0 && _x < grid.length && _y >= 0 && _y < grid[0].length
                        && grid[_x][_y] == '1') {
                    queue.add(new int[]{_x, _y});
                    grid[_x][_y] = '#';
                }
            }
        }

        return true;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length
                || y >= grid[0].length || grid[x][y] != '1') {
            return ;
        }

        grid[x][y] = '#';
        this.dfs(grid, x + 1, y);
        this.dfs(grid, x - 1, y);
        this.dfs(grid, x, y + 1);
        this.dfs(grid, x, y - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}