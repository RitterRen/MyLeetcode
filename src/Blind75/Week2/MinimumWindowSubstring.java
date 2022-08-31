package Blind75.Week2;

//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
// Related Topics Hash Table String Sliding Window 👍 11996 👎 564

import java.util.HashMap;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(solution.minWindow(s, t));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tDict = new HashMap<>();
        HashMap<Character, Integer> windowDict = new HashMap<>();
        int left = 0;
        int right = 0;
        int[] result = new int[2];
        int validMatchNumber = 0;
        int minDistance = Integer.MAX_VALUE;

        this.putIntoDict(t, tDict);

        while (right < s.length()) {
            char cAtRight = s.charAt(right);
            if (tDict.containsKey(cAtRight)) {
                windowDict.put(cAtRight, windowDict.getOrDefault(cAtRight, 0) + 1);
                if (windowDict.get(cAtRight).equals(tDict.get(cAtRight))) {
                    validMatchNumber++;
                }
            }
            right++;

            while (left < right && validMatchNumber == tDict.size()) {
                if (right - left < minDistance) {
                    minDistance = right - left;
                    result[0] = left;
                    result[1] = right;
                }

                char cAtLeft = s.charAt(left);
                if (tDict.containsKey(cAtLeft)) {
                    int val = windowDict.get(cAtLeft) - 1;
                    windowDict.put(cAtLeft, val);
                    if (val < tDict.get(cAtLeft)){
                        validMatchNumber--;
                    }
                }
                left++;
            }
        }

        if (minDistance == Integer.MAX_VALUE) return "";
        return s.substring(result[0], result[1]);
    }

    private boolean putIntoDict(String str, HashMap<Character, Integer> dict) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }

        return true;
    }

    private boolean removeInDict(char c, HashMap<Character, Integer> dict) {
        int value = dict.getOrDefault(c, 0) - 1;

        if (value <= 0) {
            dict.remove(c);
        } else {
            dict.put(c, value);
        }

        return true;
    }

    private boolean largeOrEqualTDict(HashMap<Character, Integer> tDict,
                               HashMap<Character, Integer> windowDict) {
        if (windowDict.size() < tDict.size()) return false;

        for (Character key : tDict.keySet()) {
            int windowNumber = windowDict.getOrDefault(key, 0);

            if (tDict.get(key) > windowNumber) {
                return false;
            }
        }

        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}