package Blind75.Week4;

//Given an unsorted array of integers nums, return the length of the longest 
//consecutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
//Therefore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Hash Table Union Find 👍 13258 👎 547

import java.util.HashSet;

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }
        int result = 0;
        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int curr = num;
                int last = 0;

                while (numSet.contains(curr)) {
                    curr++;
                    last++;
                }

                result = Math.max(result, last);
            }
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}