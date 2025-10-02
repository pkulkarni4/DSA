package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[][] examples = {
                {20, 10, 20, 30, 20, 40},
                {5, 3, 1, 2, 4},
                {4, 2, 5, 1, 6, 7, 3}
        };
        QuickSort quickSort = new QuickSort();
        for (int[] arr : examples) {
            quickSort.sort(arr, 0, arr.length - 1);
            System.out.println("Sorted: " + Arrays.toString(arr));
        }
    }

    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = partition(arr, left, right);
            sort(arr, left, m - 1);
            sort(arr, m, right);
        }
    }

    int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int m = left;
        for (int i = m; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, m++);
            }
        }
        swap(arr, right, m);

        return m;
    }

    void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
