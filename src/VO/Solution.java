package VO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * [1, 4], [2, 5] -> [1, 5]
 * [1, 2], [2, 3] -> [1, 3]
 */
public class Solution {

    // O(N) N = NLog(N) N = intervals.length
    // O(N) N = res.length
    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> {
            int start1 = interval1[0];
            int start2 = interval2[0];
            if (start1 != start2) {
                return start1 - start2;
            }
            return interval1[1] - interval2[1];
        });
        // System.out.println(Arrays.deepToString(intervals));

        List<int[]> temp = new LinkedList<>();
        // int i = 0;
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[0] = Math.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                temp.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        temp.add(currentInterval);
        //System.out.println(temp);

        int[][] res = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{4, 5}, {1, 4}};

        System.out.println(Arrays.deepToString(solution.mergeIntervals(intervals1)));
        System.out.println(Arrays.deepToString(solution.mergeIntervals(intervals2)));
    }
}
