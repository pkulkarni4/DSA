package chapter08;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {5, 6, 0, 1, 7, 3, 5}; //{0, 1, 0, 3, 2, 3}; //
        LongestIncreasingSubsequenceSolution s = new LongestIncreasingSubsequenceSolution();
        int l = s.lengthOfLIS(nums);
        System.out.println(l);
    }
}

class LongestIncreasingSubsequenceSolution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
       /* for(int i: dp) {
            System.out.print(i+ " ");
        }*/
        return maxLen;
    }
}