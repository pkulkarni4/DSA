package arrays.sorting;

import java.util.Arrays;

public class SortArrayByParity905 {
    public static void main(String[] args) {

        int[][] examples = {
                {4, 2, 1, 3},
                {1, 2, 3, 4},
                {3, 1, 2, 4},
                {7, 5, 3, 2},
                {0},
                {0, 1, 2}
        };
        SortArrayByParity905Solution s = new SortArrayByParity905Solution();
        for (int[] input : examples) {
            int[] parity = s.sortArrayByParity(input);
            System.out.println(" " + Arrays.toString(parity));
        }
    }
}

class SortArrayByParity905Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;
        if (len == 1) return nums;

        int[] res = new int[len];
        int resIdx = 0;

        int i = 0, j = len - 1;
        while (i <= len - 1) {
            if (nums[i] % 2 == 0) {
                res[resIdx] = nums[i];
                resIdx++;
            } else {
                res[j] = nums[i];
                j--;
            }
            i++;
        }

        return res;
    }

}
