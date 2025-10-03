package arrays.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortIntegersByBitCount1356 {
    public static void main(String[] args) {
        int[][] examples = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8},
                {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}
        };
        SortIntegersByBitCount1356Solution sol = new SortIntegersByBitCount1356Solution();
        for (int[] input : examples) {
            int[] res = sol.sortByBits(input);
            System.out.println(" " + Arrays.toString(res));
        }
    }
}

class SortIntegersByBitCount1356Solution {
    public int[] sortByBits(int[] arr) {
        List<BitCountInt> list = new ArrayList<>();
        for (int i : arr) {
            // System.out.println(" i ==> " + i + " bit count==>" + Integer.bitCount(i));
            list.add(new BitCountInt(i, Integer.bitCount(i)));
        }
        list.sort((a, b) -> {
            int countdiff = a.bitcount - b.bitcount;
            if (countdiff == 0) {
                return a.num - b.num;
            }
            return countdiff;
        });

        int[] res = new int[arr.length];
        int i = 0;
        for (BitCountInt b : list) {
            res[i++] = b.num;
        }

        return res;

    }
}

class BitCountInt {
    int num;
    int bitcount;

    public BitCountInt(int num, int bitcount) {
        this.num = num;
        this.bitcount = bitcount;
    }
}