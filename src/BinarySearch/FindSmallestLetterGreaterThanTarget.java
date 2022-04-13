package BinarySearch;

////Given a characters array letters that is sorted in non-decreasing order and 
//a 
////character target, return the smallest character in the array that is larger 
//
////than target. 
////
//// Note that the letters wrap around. 
////
//// 
//// For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
// 
//// 
////
//// 
//// Example 1: 
////
//// 
////Input: letters = ["c","f","j"], target = "a"
////Output: "c"
//// 
////
//// Example 2: 
////
//// 
////Input: letters = ["c","f","j"], target = "c"
////Output: "f"
//// 
////
//// Example 3: 
////
//// 
////Input: letters = ["c","f","j"], target = "d"
////Output: "f"
//// 
////
//// 
//// Constraints: 
////
//// 
//// 2 <= letters.length <= 10⁴ 
//// letters[i] is a lowercase English letter. 
//// letters is sorted in non-decreasing order. 
//// letters contains at least two different characters. 
//// target is a lowercase English letter. 
//// 
//// Related Topics 数组 二分查找 👍 214 👎 0
//

public class FindSmallestLetterGreaterThanTarget{
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            }else if (letters[mid] < target) {
                left = mid + 1;
            }else if (letters[mid] == target) {
                left = mid + 1;
            }
        }

        if (left >= letters.length) {
            return letters[0];
        }
        return letters[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}