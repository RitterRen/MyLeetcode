package Blind75.Week4;

//Given an array of meeting time intervals where intervals[i] = [starti, endi], 
//determine if a person could attend all meetings. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: false
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: true
// 
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁶ 
// 
// Related Topics Array Sorting 👍 1627 👎 79

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms{
    public static void main(String[] args) {
        Solution solution = new MeetingRooms().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}