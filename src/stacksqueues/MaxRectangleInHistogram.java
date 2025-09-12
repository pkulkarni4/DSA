package stacksqueues;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

heights = [4, 2, 8, 6, 5, 3]
output = 15

 */
public class MaxRectangleInHistogram {
    public static void main(String[] args) {
        int[][] heights = {
                {4, 2, 8, 6, 5, 3}/*,
                {2, 1, 5, 6, 2, 3},
                {4, 2, 3},
                {2, 3},
                {2, 4},
                */
        };
        MaxRectangleInHistogramSolution s = new MaxRectangleInHistogramSolution();
        for (int i = 0; i < heights.length; i++) {
            int maxArea = s.largestRectangleArea(heights[i]);
            System.out.println(maxArea);
        }
        System.out.println("**** using bruteforce ***** ");
        for (int i = 0; i < heights.length; i++) {
            int maxArea = s.largestRectangleAreaBruteForce(heights[i]);
            System.out.println(maxArea);
        }
        System.out.println("**** using stack ***** ");
        for (int i = 0; i < heights.length; i++) {
            int maxArea = s.maxAreaUsingStack(heights[i]);
            System.out.println(maxArea);
        }
    }
}

class MaxRectangleInHistogramSolution {
    public int largestRectangleAreaBruteForce(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0; // Base Condition
        int maxArea = 0;
        int left[] = new int[n]; //fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i - 1; // previous for comparing the heights
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }
        // Similarly we do for right
        for (int i = n - 2; i >= 0; i--) {
            int prev = i + 1;
            while (prev < n && heights[prev] >= heights[i]) {
                prev = right[prev];
            }
            right[i] = prev;
        }
        // once we have these two arrays fill we need width & area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;

    }

    /*
this will not work as it either goes to left or right to construct a rectangle, but it has to do both left and right
 */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, i = 0, maxArea = 0;
        while (i <= len - 1) {
            int j = i + 1;
            while (j <= len - 2 && heights[i] <= heights[j]) {
                j++;
            }
            int area = heights[i] * (j - i);
            maxArea = Math.max(maxArea, area);
            i++;
        }
        i = len - 1;
        while (i >= 0) {
            int j = i - 1;
            while (j >= 0 && heights[i] <= heights[j]) {
                j--;
            }
            int area = heights[i] * (i - j);
            maxArea = Math.max(maxArea, area);
            i--;
        }

        return maxArea;
    }

    public int maxAreaUsingStack(int[] histogram) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        for (int bar = 0; bar <= histogram.length; bar++) {

            int barHeight;
            if (bar == histogram.length) {
                barHeight = 0; // take into account last bar
            } else {
                barHeight = histogram[bar];
            }

            while (!stack.empty() && barHeight < histogram[stack.peek()]) {

                // we found a bar smaller than the one from the stack
                int top = stack.pop();

                // find left boundary
                int left = stack.isEmpty() ? -1 : stack.peek();

                // find the width of the rectangular area
                int areaRectWidth = bar - left - 1;

                // compute area of the current rectangle
                int area = areaRectWidth * histogram[top];
                maxArea = Integer.max(area, maxArea);
            }

            // add current bar (index) into the stack
            stack.push(bar);
        }

        return maxArea;
    }
}
