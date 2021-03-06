package DP;

/////**
////Given an integer array nums, return the length of the longest strictly 
////increasing subsequence. 
////
//// A subsequence is a sequence that can be derived from an array by deleting 
////some 
////or no elements without changing the order of the remaining elements. For 
////example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
////
//// 
//// Example 1: 
////
//// 
////Input: nums = [10,9,2,5,3,7,101,18]
////Output: 4
////Explanation: The longest increasing subsequence is [2,3,7,101], therefore 
//the 
////
////length is 4.
//// 
////
//// Example 2: 
////
//// 
////Input: nums = [0,1,0,3,2,3]
////Output: 4
//// 
////
//// Example 3: 
////
//// 
////Input: nums = [7,7,7,7,7,7,7]
////Output: 1
//// 
////
//// 
//// Constraints: 
////
//// 
//// 1 <= nums.length <= 2500 
//// -10⁴ <= nums[i] <= 10⁴ 
//// 
////
//// 
//// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//
////complexity? 
//// Related Topics 数组 二分查找 动态规划 👍 2403 👎 0
////
////*/
//

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(solution.lengthOfLIS(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            int j = i - 1;

            while (j > -1) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                j--;
            }

            result = Math.max(dp[i], result);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}