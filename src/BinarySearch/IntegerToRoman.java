package BinarySearch;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. 
//
// 
// Example 1: 
//
// 
//Input: num = 3
//Output: "III"
//Explanation: 3 is represented as 3 ones.
// 
//
// Example 2: 
//
// 
//Input: num = 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 3: 
//
// 
//Input: num = 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 👍 853 👎 0

import java.util.HashMap;

public class IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
        int number = 1994;

        System.out.println(solution.intToRoman(number));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static HashMap<Integer, String> dictionary = null;

    public Solution() {
        dictionary = new HashMap<>();

        //Symbol       Value
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        dictionary.put(1, "I");
        dictionary.put(4, "IV");
        dictionary.put(5, "V");
        dictionary.put(9, "IX");
        dictionary.put(10, "X");
        dictionary.put(40, "XL");
        dictionary.put(50, "L");
        dictionary.put(90, "XC");
        dictionary.put(100, "C");
        dictionary.put(400, "CD");
        dictionary.put(500, "D");
        dictionary.put(900, "CM");
        dictionary.put(1000, "M");
    }


    public String intToRoman(int num) {
        int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int left = 0;
        int right = keys.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num > keys[mid]) {
                left = mid + 1;
            }else if (num < keys[mid]) {
                right = mid - 1;
            }else if (num == keys[mid]) {
                right = mid - 1;
            }
        }

        //System.out.println("left = " + keys[left]);

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            while (left >= keys.length || num < keys[left]) {
                left--;
            }
            sb.append(dictionary.get(keys[left]));
            num -= keys[left];
        }

        return sb.toString();
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}