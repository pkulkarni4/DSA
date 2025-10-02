package sorting;

import java.util.Arrays;

/*
Merge sort - divide and conquer
 */
public class MergeSort {
    public static void main(String[] args) {
        int[][] examples = {
                {20, 10, 20, 30, 20, 40},
                {5, 3, 1, 2, 4},
                {5, 2, 3, 1}
        };
        MergeSort mergeSort = new MergeSort();
        for (int[] arr : examples) {
            int[] nums = mergeSort.sortArray(arr, 0, arr.length - 1);
            // print arr
            System.out.println("Sorted: " + Arrays.toString(nums));
        }
    }

    int[] sortArray(int[] arr, int start, int end) {
        mergeSort(arr, start, end);
        return arr;
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    /*
    two sub arrays to be merged start from start to mid and mid+1 to end
     */
    void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int leftPtr = 0, rightPtr = 0, k = start;
        while (leftPtr < n1 && rightPtr < n2) {
            if (leftArr[leftPtr] <= rightArr[rightPtr]) {
                arr[k] = leftArr[leftPtr];
                leftPtr++;
            } else {
                arr[k] = rightArr[rightPtr];
                rightPtr++;
            }
            k++;
        }
        // copy left
        while (leftPtr < n1) {
            arr[k] = leftArr[leftPtr];
            leftPtr++;
            k++;
        }

        // copy right
        while (rightPtr < n2) {
            arr[k] = rightArr[rightPtr];
            rightPtr++;
            k++;
        }
    }
}
