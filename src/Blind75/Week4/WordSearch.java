package Blind75.Week4;

////Given an m x n grid of characters board and a string word, return true if 
////word exists in the grid. 
////
//// The word can be constructed from letters of sequentially adjacent cells, 
////where adjacent cells are horizontally or vertically neighboring. The same 
//letter 
////cell may not be used more than once. 
////
//// 
//// Example 1: 
////
//// 
////Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
//word =
//// "ABCCED"
////Output: true
//// 
////
//// Example 2: 
////
//// 
////Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
//word =
//// "SEE"
////Output: true
//// 
////
//// Example 3: 
////
//// 
////Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], 
//word =
//// "ABCB"
////Output: false
//// 
////
//// 
//// Constraints: 
////
//// 
//// m == board.length 
//// n = board[i].length 
//// 1 <= m, n <= 6 
//// 1 <= word.length <= 15 
//// board and word consists of only lowercase and uppercase English letters. 
//// 
////
//// 
//// Follow up: Could you use search pruning to make your solution faster with 
//a 
////larger board? 
//// Related Topics Array Backtracking Matrix 👍 10936 👎 413
//

public class WordSearch{
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArr[0]) {
                    if (this.backtrack(board, wordArr, visited, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, char[] wordArr, boolean[][] visited, int x, int y, int index) {
        if (index == wordArr.length) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != wordArr[index]) return false;

        //char temp = board[x][y];
        board[x][y] = '#';
        //visited[x][y] = true;
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] direct : direction) {
            int xx = x + direct[0];
            int yy = y + direct[1];

            if (this.backtrack(board, wordArr, visited, xx, yy, index + 1)) {
                //System.out.println(Arrays.deepToString(board));
                return true;
            }
        }
        board[x][y] = wordArr[index];
        //visited[x][y] = false;
        // System.out.println(Arrays.deepToString(board));
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}