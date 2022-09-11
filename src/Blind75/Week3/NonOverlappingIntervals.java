package Blind75.Week3;

//Given an array of intervals intervals where intervals[i] = [starti, endi], 
//return the minimum number of intervals you need to remove to make the rest of the 
//intervals non-overlapping. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-
//overlapping.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals 
//non-overlapping.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're 
//already non-overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
// Related Topics Array Dynamic Programming Greedy Sorting 👍 4654 👎 134

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] nums1 = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        solution.eraseOverlapIntervals(nums1);
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int result = 0;
        int i = 0;
        int j = i + 1;

        while (j < intervals.length) {
            int[] interval1 = intervals[i];
            int[] interval2 = intervals[j];

            if (interval2[0] < interval1[1]) {
                result++;
            } else {
                i = j;
            }
            j++;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}