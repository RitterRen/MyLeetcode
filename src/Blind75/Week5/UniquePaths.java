package Blind75.Week5;

//There is a robot on an m x n grid. The robot is initially located at the top-
//left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right 
//corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at 
//any point in time. 
//
// Given the two integers m and n, return the number of possible unique paths 
//that the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal 
//to 2 * 10⁹. 
//
// 
// Example 1: 
// 
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach 
//the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
//
// Related Topics Math Dynamic Programming Combinatorics 👍 11884 👎 350

public class UniquePaths{
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        return this.countPath(0, 0, m, n, new int[m][n]);
    }

    private int countPath(int x, int y, int m, int n, int[][] dp) {
        if (x == m - 1 && y == n - 1) return 1;
        if (x >= m || y >= n) return 0;

        if (dp[x][y] == 0) {
            int rightPathCount = this.countPath(x, y + 1, m, n, dp);
            int downPathCount = this.countPath(x + 1, y, m, n, dp);

            dp[x][y] = rightPathCount + downPathCount;
        }


        return dp[x][y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}