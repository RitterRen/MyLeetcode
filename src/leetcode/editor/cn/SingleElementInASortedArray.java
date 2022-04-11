package leetcode.editor.cn;

//You are given a sorted array consisting of only integers where every element 
//appears exactly twice, except for one element which appears exactly once. 
//
// Return the single element that appears only once. 
//
// Your solution must run in O(log n) time and O(1) space. 
//
// 
// Example 1: 
// Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
// Example 2: 
// Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 495 👎 0

public class SingleElementInASortedArray{
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(solution.singleNonDuplicate(nums));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0 && mid + 1 < nums.length && nums[mid] == nums[mid + 1]
                    || mid % 2 != 0 && mid - 1 >= 0 && nums[mid] == nums[mid - 1]) left = mid + 1;
            else if ((mid - 1 > -1 && mid % 2 == 0 && nums[mid] == nums[mid - 1])
                    || (mid < nums.length - 1 && mid % 2 != 0 && nums[mid] == nums[mid + 1])) right = mid - 1;
            else return nums[mid];
        }

        return nums[left - 1];
    }

    //Non-Binary Search Solution O(n)
    public int singleNonDuplicate2(int[] nums) {
        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) return nums[i];
        }

        return nums[nums.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}