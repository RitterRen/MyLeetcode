package Blind75.Week2;

//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 👍 28046 👎 1205

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashSet<Character> characters = new HashSet<>();
        int result = 0;

        while (right < s.length()) {
            Character rightChar = s.charAt(right);

            while (characters.contains(rightChar) && left < right) {
                Character leftChar = s.charAt(left);
                characters.remove(leftChar);
                left++;
            }

            characters.add(rightChar);
            right++;

            result = Math.max(result, right - left);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}