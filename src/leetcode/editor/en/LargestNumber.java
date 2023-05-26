package leetcode.editor.en;

//Given a list of non-negative integers nums, arrange them such that they form 
//the largest number and return it. 
//
// Since the result may be very large, so you need to return a string instead 
//of an integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,2]
//Output: "210"
// 
//
// Example 2: 
//
// 
//Input: nums = [3,30,34,5,9]
//Output: "9534330"
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array String Greedy Sorting 👍 6949 👎 567

import java.util.*;

public class LargestNumber{
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        int[] testcase1 = {2, 10};
        int[] testcase2 = {3,30,34,5,9};
        System.out.println(solution.largestNumber(testcase1));
        System.out.println(solution.largestNumber(testcase2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length <= 1) return Integer.toString(nums[0]);

        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        System.out.println(Arrays.toString(nums2));

        Arrays.sort(nums2, (o1, o2) -> {
            String s1 = o1.toString();
            String s2 = o2.toString();
            int p1 = 0;
            int p2 = 0;

            while (p1 < s1.length() && p2 < s2.length()) {
                int num1 = Character.getNumericValue(s1.charAt(p1++));
                int num2 = Character.getNumericValue(s2.charAt(p2++));

                if (num1 != num2) {
                    return num2 - num1;
                }
            }
            while (p1 < s1.length()) {
                int num1 = Character.getNumericValue(s1.charAt(p1++));
                int num2 = Character.getNumericValue(s2.charAt(p2 - 1));

                if (num1 != num2) {
                    return num2 - num1;
                }
            }
            while (p2 < s2.length()) {
                int num1 = Character.getNumericValue(s1.charAt(p1 - 1));
                int num2 = Character.getNumericValue(s2.charAt(p2++));

                if (num1 != num2) {
                    return num2 - num1;
                }
            }

            return 0;
        });

        System.out.println(Arrays.toString(nums2));

        StringBuilder sb = new StringBuilder();
        for (Integer num : nums2) {
            sb.append(num);
        }

        return sb.toString();
    }

    private static boolean compareNumeric(String s1, String s2) {
        int p1 = 0;
        int p2 = 0;

        while (p1 < s1.length() && p2 < s2.length()) {
            char c1 = s1.charAt(p1++);
            char c2 = s2.charAt(p2++);

            if (Character.getNumericValue(c1) > Character.getNumericValue(c2)) return true;
            else if (Character.getNumericValue(c1) < Character.getNumericValue(c2)) return false;
        }

        while (p1 < s1.length()) {
            char c1 = s1.charAt(p1++);
            char c2 = s2.charAt(p2 - 1);

            if (Character.getNumericValue(c1) > Character.getNumericValue(c2)) return true;
            else if (Character.getNumericValue(c1) < Character.getNumericValue(c2)) return false;
        }

        while (p2 < s2.length()) {
            char c1 = s1.charAt(p1 - 1);
            char c2 = s2.charAt(p2++);

            if (Character.getNumericValue(c1) > Character.getNumericValue(c2)) return true;
            else if (Character.getNumericValue(c1) < Character.getNumericValue(c2)) return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}