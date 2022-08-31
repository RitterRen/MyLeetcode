package Blind75.Week2;

//There is an m x n rectangular island that borders both the Pacific Ocean and 
//Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and 
//the Atlantic Ocean touches the island's right and bottom edges. 
//
// The island is partitioned into a grid of square cells. You are given an m x 
//n integer matrix heights where heights[r][c] represents the height above sea 
//level of the cell at coordinate (r, c). 
//
// The island receives a lot of rain, and the rain water can flow to 
//neighboring cells directly north, south, east, and west if the neighboring cell's height 
//is less than or equal to the current cell's height. Water can flow from any cell 
//adjacent to an ocean into the ocean. 
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
//denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
//oceans. 
//
// 
// Example 1: 
//
// 
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//Explanation: The following cells can flow to the Pacific and Atlantic oceans, 
//as shown below:
//[0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
//Note that there are other possible paths for these cells to flow to the 
//Pacific and Atlantic oceans.
// 
//
// Example 2: 
//
// 
//Input: heights = [[1]]
//Output: [[0,0]]
//Explanation: The water can flow from the only cell to the Pacific and 
//Atlantic oceans.
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 4541 ?
//? 960

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow{
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (this.bfsToEachSide(heights, i, j)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }

        return result;
    }

    private boolean bfsToEachSide(int[][] heights, int x, int y) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean reachPacific = false, reachAtlantic = false;

        while (!queue.isEmpty()) {
            int[] xAndY = queue.pollFirst();
            int nx = xAndY[0];
            int ny = xAndY[1];

            for (int[] direct : direction) {
                int _x = nx + direct[0];
                int _y = ny + direct[1];

                if (_x < 0) reachPacific = true;
                if (_x >= heights.length) reachAtlantic = true;
                if (_y < 0) reachPacific = true;
                if (_y >= heights[0].length) reachAtlantic = true;

                if (reachAtlantic && reachPacific) break;

                if (_x >= 0 && _x < heights.length && _y >= 0 && _y < heights[0].length
                        && heights[nx][ny] >= heights[_x][_y] && !visited[_x][_y]) {
                    queue.add(new int[]{_x, _y});
                    visited[_x][_y] = true;
                }
            }

            if (reachAtlantic && reachPacific) break;

        }

        return reachAtlantic && reachPacific;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}