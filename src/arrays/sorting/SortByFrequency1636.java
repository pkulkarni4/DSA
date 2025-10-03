package arrays.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
LC#1636: Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.

*/

public class SortByFrequency1636 {
    public static void main(String[] args) {
        SortByFrequency1636Solution sol = new SortByFrequency1636Solution();
        int[][] examples = {
                {1, 1, 2, 2, 2, 3},
                {2, 3, 1, 3, 2},
                {-1, 1, -6, 4, 5, -6, 1, 4, 1}
        };
        for (int[] input : examples) {
            int[] res = sol.frequencySort(input);
            System.out.println("output ==> " + Arrays.toString(res));
        }

    }
}

class SortByFrequency1636Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();
        int length = nums.length;
        Integer[] numsObj = new Integer[length];

        int idx = 0;
        for (int n : nums) {
            numsObj[idx++] = n;
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (frequency.get(a).equals(frequency.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(frequency.get(a), frequency.get(b));
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}
