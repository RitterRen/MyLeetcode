package Blind75.Week3;

//Given the root of a binary tree, invert the tree, and return its root. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,3,1]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 96
//08 👎 132

public class InvertBinaryTree{
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        
        System.out.println();
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

    // use the post traverse
    public TreeNode invertTree(TreeNode root) {
        this.invertTreeHelper(root);

        return root;
    }

    private void invertTreeHelper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}