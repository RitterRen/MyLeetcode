package Blind75.Week1;

//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input.
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics Array Sorting 👍 15322 👎 553

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        // System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});
        int[] latestInterval = result.get(0);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            if (currentInterval[0] <= latestInterval[1]) {
                latestInterval[1] = Math.max(latestInterval[1], currentInterval[1]);
            } else {
                int[] temp = new int[]{currentInterval[0], currentInterval[1]} ;
                result.add(temp);
                latestInterval = temp;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}