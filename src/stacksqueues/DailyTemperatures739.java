package stacksqueues;

import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Ex:
input, temp = [73,74,75,71,69,72,76,71,73]
output: [1, 1, 4, 2, 1, 1, 0, 1, 0]
input, temp = [30, 40, 50, 60]
output: [1,1,1,0]
 */
public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[][] examples = {
                {73, 74, 75, 71, 69, 72, 76, 71, 73},
                {30, 40, 50, 60},
                {51, 52, 56, 51, 53}
        };
        Solution739 s = new Solution739();
        for (int[] e : examples) {
            int[] res = s.dailyTemperatures(e);
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution739 {
    /*
    Solution uses monotonic stack
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                int top = stack.pop();
            }
            if (!stack.empty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}