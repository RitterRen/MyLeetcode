package Blind75.Week1;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 👍 14695 👎 712

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final HashMap<Character, Character> syntaxDict = new HashMap<>();

    public boolean isValid(String s) {
        this.initiateDict();

        LinkedList<Character> stack = new LinkedList<>();
        //boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!syntaxDict.containsKey(c)) { // c not in ")]}"
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                Character temp = stack.pop();
                if (syntaxDict.get(c) != temp) return false;

            }
        }

        return stack.isEmpty();
    }

    private void initiateDict() {
        syntaxDict.put(')', '(');
        syntaxDict.put(']', '[');
        syntaxDict.put('}', '{');
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}