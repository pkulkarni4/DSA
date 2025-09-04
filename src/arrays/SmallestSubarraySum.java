package arrays;

public class SmallestSubarraySum {
    public static void main(String[] args) {
        int[] input = {4,2,2,7,8,1,2,8,10};
        int k =8;
        SmallestSubarraySumSolution s = new SmallestSubarraySumSolution();

        System.out.println(" " + s.smallestSubArray(input, k));
    }
}

class SmallestSubarraySumSolution {
    int smallestSubArray(int[] nums, int target) {
        int len = nums.length, minWindowSize = Integer.MAX_VALUE, currentWindowSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < len; windowEnd++) {
            currentWindowSum = currentWindowSum + nums[windowEnd];
            while(currentWindowSum>=target) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum = currentWindowSum - nums[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }

}
