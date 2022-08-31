package Blind75.Week1;

//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
// Related Topics Hash Table String Sorting 👍 6439 👎 236

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] characterTimesForT = this.countCharacter(s);
        int[] characterTimesForS = this.countCharacter(t);

        for (int i = 0; i < 26; i++) {
            if (characterTimesForS[i] != characterTimesForT[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] countCharacter(String str) {
        int[] result = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result[c - 'a']++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}