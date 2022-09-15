package Blind75.Week3;

//Given the root of a binary tree, return the level order traversal of its 
//nodes' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
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
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Breadth-First Search Binary Tree 👍 10710 👎 201

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
        System.out.println();
    }
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // BFS
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<List<Integer>> result = new ArrayList<>();

        while (!deque.isEmpty()) {
            result.add(this.copyFromQueue(deque));
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();

                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }

        return result;
    }

    private List<Integer> copyFromQueue(LinkedList<TreeNode> deque) {
        List<Integer> copyArr = new ArrayList<>();

        for (int i = 0; i < deque.size(); i++) {
            copyArr.add(deque.get(i).val);
        }

        return copyArr;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}