package DP;

//You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can 
//you climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2346 👎 0

public class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        int n = 3;
        System.out.println(solution.climbStairs(n));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            return 0;
        }
        int n1 = 1;
        int n2 = 2;

        int res = 1;
        while (n > 2) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
            n--;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}