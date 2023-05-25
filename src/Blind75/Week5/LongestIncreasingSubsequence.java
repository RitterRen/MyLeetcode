package Blind75.Week5;

//Given an integer array nums, return the length of the longest strictly 
//increasing subsequence. 
//
// A subsequence is a sequence that can be derived from an array by deleting 
//some or no elements without changing the order of the remaining elements. For 
//example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 15137 👎 270

import java.util.ArrayList;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        //int result = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr.get(arr.size() - 1)) {
                arr.add(nums[i]);
            } else {
                int index = this.binarySearch(arr, nums[i]);
                arr.set(index, nums[i]);
            }
        }

        return arr.size();
    }

    private int binarySearch(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                right = mid;
            } else if (arr.get(mid) > target) {
                right = mid;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}