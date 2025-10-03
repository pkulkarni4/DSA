package arrays.sorting;

import java.util.Arrays;

public class SortArrayByParityII922 {
    public static void main(String[] args) {
        int[][] examples = {
                {4, 2, 1, 3},
                {4, 2, 6, 3, 1, 5},
                {3, 1, 5, 4, 2, 6},
                {4, 2, 5, 7},
                {5, 7, 4, 2},
                {1, 3, 4, 2}
        };
        SortArrayByParityII922Solution s = new SortArrayByParityII922Solution();
        for (int[] input : examples) {
            int[] parity = s.sortArrayByParityII(input);
            System.out.println(" " + Arrays.toString(parity));
        }
    }
}

class SortArrayByParityII922Solution {
    /*
    nums length has to be even
     */
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] even = new int[len / 2];
        int[] odd = new int[len / 2];
        int i = 0, j = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                even[i++] = n;
            } else {
                odd[j++] = n;
            }
        }
        // System.out.println("even: " + Arrays.toString(even));
        // System.out.println("odd : " + Arrays.toString(odd));
        i = 0;
        j = 0;
        int[] res = new int[len];
        for (int k = 0; k < len - 1; k += 2) {
            res[k] = even[i++];
            res[k + 1] = odd[j++];
        }
        return res;
    }
}