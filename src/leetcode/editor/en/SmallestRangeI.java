package leetcode.editor.en;

//You are given an integer array nums and an integer k. 
//
// In one operation, you can choose any index i where 0 <= i < nums.length and 
//change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You 
//can apply this operation at most once for each index i. 
//
// The score of nums is the difference between the maximum and minimum elements 
//in nums. 
//
// Return the minimum score of nums after applying the mentioned operation at 
//most once for each index in it. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1], k = 0
//Output: 0
//Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,10], k = 2
//Output: 6
//Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 
//- 2 = 6.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,6], k = 3
//Output: 0
//Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) =
// 4 - 4 = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁴ 
// 0 <= k <= 10⁴ 
// 
// Related Topics Array Math 👍 470 👎 1694

public class SmallestRangeI{
    public static void main(String[] args) {
        Solution solution = new SmallestRangeI().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int maxValue = this.findMaxValue(nums);
        int minValue = this.findMinValue(nums);

        if (maxValue - minValue <= 2 * k) return 0;

        return maxValue - minValue - 2 * k;
    }

    private int findMaxValue(int[] arr) {
        int maxValue = 0;

        for (int num : arr) {
            maxValue = Math.max(maxValue, num);
        }

        return maxValue;
    }

    private int findMinValue(int[] arr) {
        int minValue = Integer.MAX_VALUE;

        for (int num : arr) {
            minValue = Math.min(minValue, num);
        }

        return minValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}