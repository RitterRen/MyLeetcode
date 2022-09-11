package Blind75.Week3;

//Given two integer arrays preorder and inorder where preorder is the preorder 
//traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 10876 
//👎 296

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{

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
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.buildTreeHelper(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder,
                                     int preOrderLeft, int preOrderRight,
                                     int inOrderLeft, int inOrderRight ) {

        if (preOrderLeft < 0 || preOrderRight >= preorder.length
            || inOrderLeft < 0 || inOrderRight >= inorder.length
            || preOrderLeft > preOrderRight || inOrderLeft > inOrderRight) {
            return null;
        }

        int rootVal = preorder[preOrderLeft];
        int rootIndex = this.findRootIndexFromPreOrder(inorder, rootVal, inOrderLeft, inOrderRight);
        TreeNode root = new TreeNode(rootVal);

        root.left = this.buildTreeHelper(preorder, inorder,
                 preOrderLeft + 1, preOrderLeft + rootIndex - inOrderLeft,
                inOrderLeft, rootIndex - 1);
        root.right = this.buildTreeHelper(preorder, inorder,
                preOrderLeft + rootIndex - inOrderLeft + 1, preOrderRight,
                rootIndex + 1, inOrderRight);

        return root;
    }

    private int findRootIndexFromPreOrder(int[] inorder, int rootVal,
                                          int inOrderLeft, int inOrderRight) {

        for (int i = inOrderLeft; i <= inOrderRight; i++) {
            if (inorder[i] == rootVal) return i;
        }

        return inOrderRight;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}