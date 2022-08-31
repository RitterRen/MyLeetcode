package Blind75.Week2;

//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 👍 7890 👎 170

public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] sArray = s.toCharArray();
        int countPalindromeSubString = 0;

        for (int i = 0; i < sArray.length; i++) {
            if (i < sArray.length - 1) {
                countPalindromeSubString += this.countPalindrome(sArray, i, i + 1);
            }
            countPalindromeSubString += this.countPalindrome(sArray, i, i);
        }

        return countPalindromeSubString;
    }

    private int countPalindrome(char[] sArray, int left, int right) {
        int result = 0;

        while (left >= 0 && right < sArray.length) {
            if (sArray[left] != sArray[right]) break;

            left--;
            right++;
            result++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}