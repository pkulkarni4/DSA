package arrays;

public class LongestSubsequenceWithNonZeroXOR {
    public static void main(String[] args) {
        LongestSubsequenceWithNonZeroXORSolution sol = new LongestSubsequenceWithNonZeroXORSolution();
        int[][] examples = {
                {1, 2, 3},
                {2, 3, 4}
        };
        for (int[] input : examples) {
            int nonZero = sol.longestSubsequence(input);
            System.out.println(nonZero);
        }
    }
}

class LongestSubsequenceWithNonZeroXORSolution {
    public int longestSubsequence(int[] nums) {
        int length = nums.length;
        int xSum = 0;
        boolean flag = false;

        for (int i = 0; i < length; i++) {
            xSum = xSum ^ nums[i];
            if (nums[i] != 0) {
                flag = true;
            }
        }
        if (xSum != 0) return length;

        if (flag) return length - 1;

        return 0;

    }
}
