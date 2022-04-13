package BinarySearch;

//Given an array of integers nums sorted in non-decreasing order, find the 
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1606 👎 0

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3, 3, 5, 5, 5, 8, 8, 9, 10};
        int target = 11;
        //solution.searchRange(nums, target);
        System.out.println(Solution.findLeftBoundry(nums, target));
        System.out.println(Solution.findRightBoundry(nums, target));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                break;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left != right) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        while (left > 0 && nums[left - 1] == target) left--;
        while (right < nums.length - 1 && nums[right + 1] == target) right++;

        result[0] = left;
        result[1] = right;

        return result;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};

        int leftBoundry = findLeftBoundry(nums, target);
        int rightBoundry = findRightBoundry(nums, target);

        if (leftBoundry >= nums.length || nums[leftBoundry] != target) return new int[]{-1, -1};

        return new int[]{leftBoundry, rightBoundry};
    }

    public static int findRightBoundry(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static int findLeftBoundry(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}