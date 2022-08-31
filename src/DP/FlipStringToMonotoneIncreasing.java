package DP;

//A binary string is monotone increasing if it consists of some number of 0's (
//possibly none), followed by some number of 1's (also possibly none). 
//
// You are given a binary string s. You can flip s[i] changing it from 0 to 1 
//or from 1 to 0. 
//
// Return the minimum number of flips to make s monotone increasing. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110"
//Output: 1
//Explanation: We flip the last digit to get 00111.
// 
//
// Example 2: 
//
// 
//Input: s = "010110"
//Output: 2
//Explanation: We flip to get 011111, or alternatively 000111.
// 
//
// Example 3: 
//
// 
//Input: s = "00011000"
//Output: 2
//Explanation: We flip to get 00000000.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either '0' or '1'. 
// 
// Related Topics 字符串 动态规划 👍 146 👎 0

public class FlipStringToMonotoneIncreasing{
    public static void main(String[] args) {
        Solution solution = new FlipStringToMonotoneIncreasing().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlipsMonoIncr(String s) {
        // dynamic programming
        int[][] dp = new int[s.length()][2];
        int dp0 = s.charAt(0) == '0' ? 0 : 1;
        int dp1 = s.charAt(0) == '1' ? 0 : 1;
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }else { // s.charAt(i) == '1'
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }

        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}