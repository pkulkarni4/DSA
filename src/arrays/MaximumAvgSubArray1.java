package arrays;


/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.

Any answer with a calculation error less than 10^5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
 */
public class MaximumAvgSubArray1 {
    public static void main(String[] args) {
        MaximumAvgSubArray1Solution ss = new MaximumAvgSubArray1Solution();
        int[][] examples = {
                {1, 12, -5, -6, 50, 3},
                {5},
                {-1},
                {3,3,4,3,0}
        };
        int[] kList = {4, 1, 1, 3};
        for (int i = 0; i < examples.length; i++) {
            double avg = ss.findMaxAverage(examples[i], kList[i]);
            System.out.println("max avg: " + avg);
        }
    }
}

class MaximumAvgSubArray1Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null) return 0;
        int length = nums.length;
        if (length == 0) return 0;
        int sum = 0;

        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        //System.out.println(" sum : " + sum);
        double maxSum = sum;
/*
        int start = 0, end = k;
        while(end < length) {
            sum -= nums[start];
            start++;
            sum += nums[end];
            end++;
            maxSum = Math.max(maxSum, sum);
        }
        */

        for (int i = 0; i < length-k; i++) {
            sum += nums[i+k] - nums[i];
            maxSum = Math.max(maxSum, sum);
           //System.out.println(" sum : " + sum + ", max avg so far: " + maxSum);
        }
        //System.out.println("max sum: " + maxSum + "/ " + k);
        return maxSum/k;
    }
}