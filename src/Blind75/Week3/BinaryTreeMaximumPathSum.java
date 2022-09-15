package Blind75.Week3;

//A path in a binary tree is a sequence of nodes where each pair of adjacent 
//nodes in the sequence has an edge connecting them. A node can only appear in the 
//sequence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any non-
//empty path. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
//
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 114
//68 👎 584

public class BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        
        System.out.println();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.maxPathSumHelper(root);

        return result;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPathSum = this.maxPathSumHelper(root.left);
        int rightPathSum = this.maxPathSumHelper(root.right);

        result = Math.max(result, Math.max(root.val,
                Math.max(root.val + leftPathSum + rightPathSum, Math.max(root.val + leftPathSum, root.val + rightPathSum))));

        return Math.max(root.val, Math.max(root.val + leftPathSum, root.val + rightPathSum));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}