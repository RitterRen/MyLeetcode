package Blind75.Week1;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 20071 👎 1899

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums1 = {-2,0,0,2,2};
        solution.threeSum(nums1);
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        //System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                while(left > i + 1 && nums[left] == nums[left - 1] && left < right) left++;
                while(right < nums.length - 1 && nums[right] == nums[right + 1] && left < right) right--;

                if (left == right) break;
                int temp = nums[i] + nums[left] + nums[right];

                if (temp == 0) {
                    List<Integer> resultList = new LinkedList<>();
                    this.addToList(resultList, nums[i], nums[left], nums[right]);
                    result.add(resultList);
                    left++;
                    right--;
                }else if (temp < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result ;
    }

    private boolean addToList(List<Integer> tempList, int n1, int n2, int n3) {
        tempList.add(n1);
        tempList.add(n2);
        tempList.add(n3);

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}