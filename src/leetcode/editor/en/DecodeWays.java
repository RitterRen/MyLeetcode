package leetcode.editor.en;

//A message containing letters from A-Z can be encoded into numbers using the 
//following mapping: 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
// 
//
// To decode an encoded message, all the digits must be grouped then mapped 
//back into letters using the reverse of the mapping above (there may be multiple 
//ways). For example, "11106" can be mapped into: 
//
// 
// "AAJF" with the grouping (1 1 10 6) 
// "KJF" with the grouping (11 10 6) 
// 
//
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
//into 'F' since "6" is different from "06". 
//
// Given a string s containing only digits, return the number of ways to decode 
//it. 
//
// The test cases are generated so that the answer fits in a 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "12"
//Output: 2
//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// 
//
// Example 2: 
//
// 
//Input: s = "226"
//Output: 3
//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
// 6).
// 
//
// Example 3: 
//
// 
//Input: s = "06"
//Output: 0
//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is 
//different from "06").
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only digits and may contain leading zero(s). 
// 
//
// Related Topics String Dynamic Programming 👍 8832 👎 4077

import java.util.Arrays;
import java.util.HashMap;

public class DecodeWays{
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        
        System.out.println(solution.numDecodings("123"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static HashMap<String, Character> dict;

    static {
        dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String key = String.valueOf(i + 1);
            Character c = (char)('A' + i);

            dict.put(key, c);
        }

        //System.out.println(dict);
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            char c = s.charAt(i - 1);
            if (c == '0') {
                if (!this.getTwoValIsValid(s.charAt(i - 2), s.charAt(i - 1))) return 0;
                dp[i] = dp[i - 2];
            } else { // c != '0'
                if (s.charAt(i - 2) != '0' && this.getTwoValIsValid(s.charAt(i - 2), s.charAt(i - 1))) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }

            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    private boolean getTwoValIsValid(char c1, char c2) {
        int val = Integer.parseInt(String.valueOf(c1)) * 10 + Integer.parseInt(String.valueOf(c2));

        return val >= 1 && val <= 26;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}