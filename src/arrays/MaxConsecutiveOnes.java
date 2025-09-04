package arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnesSolution s = new MaxConsecutiveOnesSolution();
        int[][] input = {
                {1, 1, 0, 1, 1, 1},
                {1, 0, 1}
        };
        int[][] tests = {
                {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}
        };
        int[] k = {2, 3};

        for (int i = 0; i < input.length; i++) {
            int max = s.findMaxConsecutiveOnes(input[i]);
            System.out.println(max);
        }

        for (int i = 0; i < tests.length; i++) {
            int max = s.longestOnes(tests[i], k[i]);
            System.out.println(max);
        }
    }
}

class MaxConsecutiveOnesSolution {
    /*
    Given a binary array nums, return the maximum number of consecutive 1's in the array.
    Ex: [1,1,0,1,1,1]
    ans: 3
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, len = nums.length, current_ones = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                current_ones++;
            } else {
                current_ones = 0;
            }
            max = Math.max(current_ones, max);
        }
        return max;
    }

    /*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
ex:
nums=[1,1,1,0,0,0,1,1,1,1,0], k = 2
output: 6
nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
output=10
     */
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, len = nums.length;
        while (i < len) {
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[j] == 0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }

}
