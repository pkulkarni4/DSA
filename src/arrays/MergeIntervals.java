package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] examples = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}, {4,8}};
        MergeIntervalsSolution s = new MergeIntervalsSolution();
        int[][] ret = s.merge(examples);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. sort based on first num
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        int[] current_interval = intervals[0];
        output.add(current_interval);

        for (int[] intervel : intervals) {
            int current_begin = current_interval[0];
            int current_end = current_interval[1];

            int next_begin = intervel[0];
            int next_end = intervel[1];

            // 2. compare start and end to check if there is overlap
            // 3. merge
            if (current_end >= next_begin) {
                current_interval[1] = Math.max(current_end, next_end);
            } else {
                current_interval = intervel;
                output.add(current_interval);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}