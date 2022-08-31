package GoldmanSacha_OA;

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
// Related Topics String Dynamic Programming 👍 7783 👎 169

public class PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        String str1 = "abc";
        solution.countSubstrings(str1);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        char[] chArray = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chArray.length; i++) {
            result += countPalindrome(chArray, i, i); // expand from character
            if (i < chArray.length - 1) {
                result += countPalindrome(chArray, i, i + 1); // expand from space
            }
        }

        return result;
    }

    private int countPalindrome(char[] chArray, int left, int right) {
        int result = 0;

        while (left > -1 && right < chArray.length) {
            if (chArray[left] == chArray[right]) {
                result++;
                left--;
                right++;
            } else {
                break;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}