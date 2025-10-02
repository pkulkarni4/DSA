package sorting;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[][] examples = {
                {20, 10, 20, 30, 20, 40},
                {5, 3, 1, 2, 4},
                {4, 2, 5, 1, 6, 7}
        };
        BucketSort bucketSort = new BucketSort();
        for (int[] arr : examples) {
          //  bucketSort.sort(arr, 0, arr.length - 1);
            System.out.println("Sorted: " + Arrays.toString(arr));
        }
    }

}
