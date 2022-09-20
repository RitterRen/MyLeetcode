package Blind75.Week4;

//Given the roots of two binary trees root and subRoot, return true if there is 
//a subtree of root with the same structure and node values of subRoot and false 
//otherwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree 
//and all of this node's descendants. The tree tree could also be considered as a 
//subtree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash 
//Function 👍 6194 👎 338

public class SubtreeOfAnotherTree{
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        
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
    boolean result = false;
    //HashSet<TreeNode> notSameSet = new HashSet<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.isSubtreeHelper(root, subRoot);

        return result;
    }

    private void isSubtreeHelper(TreeNode root, TreeNode subRoot) {
        if (root == null) return;

        if (root.val == subRoot.val
                && this.isSameTree(root, subRoot)) {
            result = true;
            return;
        }

        this.isSubtree(root.left, subRoot);
        this.isSubtree(root.right, subRoot);
    }

    /**
     * @description preOrder traverse to judge whether two tree is the same. root, leftTree and rightTree.
     * @param root1
     * @param root2
     * @return bool
     */
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }

        return root1.val == root2.val && this.isSameTree(root1.left, root2.left) && this.isSameTree(root1.right, root2.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}