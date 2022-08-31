package Stack;

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
// Related Topics 栈 字符串 👍 3210 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Character, Character> dict;

    public Solution() {
        dict = new HashMap<>();
        dict.put('}', '{');
        dict.put(']', '[');
        dict.put(')', '(');
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashSet<Character> leftChar = new HashSet<>();
        leftChar.add('{');
        leftChar.add('(');
        leftChar.add('[');

        for (int i = 0; i < s.length(); i++) {
            if (leftChar.contains(s.charAt(i))) {
                stack.addLast(s.charAt(i));
            }else {
                if (stack.peekLast() != dict.get(s.charAt(i))) {
                    return false;
                }
                stack.pollLast();
            }
        }

        return stack.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}