package GoldmanSacha_OA;

//Given an array of integers nums and an integer k, return the number of unique 
//k-diff pairs in the array. 
//
// A k-diff pair is an integer pair (nums[i], nums[j]), where the following are 
//true: 
//
// 
// 0 <= i, j < nums.length 
// i != j 
// nums[i] - nums[j] == k 
// 
//
// Notice that |val| denotes the absolute value of val. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1,4,1,5], k = 2
//Output: 2
//Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
//Although we have two 1s in the input, we should only return the number of 
//unique pairs.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,5], k = 1
//Output: 4
//Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) 
//and (4, 5).
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,1,5,4], k = 0
//Output: 1
//Explanation: There is one 0-diff pair in the array, (1, 1).
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁷ <= nums[i] <= 10⁷ 
// 0 <= k <= 10⁷ 
// 
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 👍 2827 👎
// 2105

import java.util.HashMap;
import java.util.HashSet;

public class KDiffPairsInAnArray{
    public static void main(String[] args) {
        Solution solution = new KDiffPairsInAnArray().new Solution();
        int[] nums = {1,2,4,4,3,3,0,9,2,3};
        solution.findPairs(nums, 3);
        System.out.println();
    }
    // num1 - num2 = k
    // num2 - num1 = k

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        HashSet<NumPair> pairSet = new HashSet<>();
        //int result = 0;

        for (int num : nums) {
            int target = k == 0? k : num + k;
            if (numsMap.containsKey(target)) {
                NumPair newPair = new NumPair(target, num);

                pairSet.add(newPair);
            }
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }

        //System.out.println(pairSet);

        return pairSet.size();
    }

    class NumPair {
        int num1;
        int num2;

        public NumPair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int hashCode() {
            return num1 * 39 + num2 * 39 + 7;
        }

        @Override
        public String toString() {
            return "("
                    + "num1 = "
                    + num1
                    +" , "
                    + "num2 = "
                    + num2
                    + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof NumPair)) return false;
            NumPair o = (NumPair) obj;

            return this.num1 == o.num1 && this.num2 == o.num2
                    || this.num1 == o.num2 && this.num2 == o.num1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}