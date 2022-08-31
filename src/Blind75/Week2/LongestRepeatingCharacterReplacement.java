package Blind75.Week2;

//You are given a string s and an integer k. You can choose any character of 
//the string and change it to any other uppercase English character. You can perform 
//this operation at most k times. 
//
// Return the length of the longest substring containing the same letter you 
//can get after performing the above operations. 
//
// 
// Example 1: 
//
// 
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
// 
//
// Example 2: 
//
// 
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of only uppercase English letters. 
// 0 <= k <= s.length 
// 
// Related Topics Hash Table String Sliding Window 👍 5868 👎 230

public class LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] countNumber = new int[26]; // from 'A' to 'Z';
        int left = 0;
        int right = 0;
        int maxAppear = 0;
        int result = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            countNumber[c - 'A'] += 1;
            maxAppear = Math.max(maxAppear, countNumber[c - 'A']);
            right++;

            while (right - left - maxAppear > k) {
                char leftC = s.charAt(left);
                countNumber[leftC - 'A'] -= 1;
                left++;
            }

            result = Math.max(right - left, result);
        }

        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}