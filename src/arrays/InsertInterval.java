package arrays;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of non-overlapping intervals 'intervals' where intervals[i] = [starti, endi] represent the start and the end of the ith interval
and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] examples = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        InsertIntervalSolution s = new InsertIntervalSolution();
        int[][] ret = s.insert(examples, new int[]{4, 8});

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] intervels : intervals) {
            // compare newInterval[0] to be in between intervels[0] and intervels[1]
            if (intervels[1] < start){
                left.add(intervels);
            } else if(intervels[0] > end) {
                right.add(intervels);
            } else {
                start = Math.min(start, intervels[0]);
                end = Math.max(end, intervels[1]);
            }
        }
        left.add(new int[] {start, end});
        left.addAll(right);

        return left.toArray(new int[left.size()][]);
    }
}
