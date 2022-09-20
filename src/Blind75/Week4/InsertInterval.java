package Blind75.Week4;

//You are given an array of non-overlapping intervals intervals where intervals[
//i] = [starti, endi] represent the start and the end of the iᵗʰ interval and 
//intervals is sorted in ascending order by starti. You are also given an interval 
//newInterval = [start, end] that represents the start and end of another interval. 
//
// Insert newInterval into intervals such that intervals is still sorted in 
//ascending order by starti and intervals still does not have any overlapping 
//intervals (merge overlapping intervals if necessary). 
//
// Return intervals after the insertion. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals is sorted by starti in ascending order. 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
// Related Topics Array 👍 5891 👎 402

import java.util.ArrayList;

public class InsertInterval{
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList<>();
        boolean merged = false;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] >= newInterval[0] && !merged) {
                arr.add(newInterval);
                merged = true;
            }
            arr.add(interval);
        }

        if (!merged) {
            arr.add(newInterval);
        }


        this.mergeInteger(arr);
        int[][] result = new int[arr.size()][2];

        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    private void mergeInteger(ArrayList<int[]> arr) {
        int i = 1;
        int[] preInterval = arr.get(0);

        while (i < arr.size()) {
            int[] currInterval = arr.get(i);

            if (currInterval[0] <= preInterval[1]) {
                preInterval[1] = Math.max(preInterval[1], currInterval[1]);
                arr.remove(i);
            } else {
                preInterval = arr.get(i++);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}