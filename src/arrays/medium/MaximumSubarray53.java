package arrays.medium;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        SolutionMaximumSubarray53 s = new SolutionMaximumSubarray53();
        int[] p = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = s.maxSubArray(p);
        System.out.println(maxSum);
        p = new int[]{1};
        maxSum = s.maxSubArray(p);
        System.out.println(maxSum);
        p = new int[]{5,4,-1,7,8};
        maxSum = s.maxSubArray(p);
        System.out.println(maxSum);
    }
}
class SolutionMaximumSubarray53 {
    public int maxSubArrayOn3(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        int length = nums.length;
        for(int i = 0; i< length; i++){
            for(int j = i; j< length; j++){
                sum =0;
                for(int k=i;k<=j;k++){
                    sum = sum + nums[k];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
    public int maxSubArrayOn2(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = nums[i];
            for(int j=i+1;j<nums.length;j++){
                    sum = sum + nums[j];
                    maxSum = Math.max(sum, maxSum);
            }

        }
        return maxSum;
    }
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            if(currSum < 0)
                currSum = 0;
            currSum += nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
