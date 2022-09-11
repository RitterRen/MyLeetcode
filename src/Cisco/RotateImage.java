package Cisco;

//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the 
//input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array Math Matrix 👍 11032 👎 547

public class RotateImage{
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        int n = (int) Math.ceil(matrix.length / 2.0);
        //System.out.println("n = " + n);

        for (int i = 0; i < matrix.length / 2 + matrix.length % 2; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                this.swap(i, j, len - j, i, len - i, len - j, j, len - i, matrix);
            }
        }
    }

    private void swap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int[][] matrix) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = matrix[x3][y3];
        matrix[x3][y3] = matrix[x4][y4];
        matrix[x4][y4] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}