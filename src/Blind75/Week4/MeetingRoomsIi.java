package Blind75.Week4;

//Given an array of meeting time intervals intervals where intervals[i] = [
//starti, endi], return the minimum number of conference rooms required. 
//
// 
// Example 1: 
// Input: intervals = [[0,30],[5,10],[15,20]]
//Output: 2
// Example 2: 
// Input: intervals = [[7,10],[2,4]]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
// Related Topics Array Two Pointers Greedy Sorting Heap (Priority Queue) 
//Prefix Sum 👍 6001 👎 128

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIi{
    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int result = 0;
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (endTime.isEmpty()) {
                endTime.add(interval[1]);
                result++;
                continue;
            }

            if (interval[0] < endTime.peek()) {
                result++;
                endTime.add(interval[1]);
            } else {
                endTime.remove();
                endTime.add(interval[1]);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}