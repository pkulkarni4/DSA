package sorting;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0);
        }
    }

    private void buildHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, len, i);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int greater = i;
        if (left < n && arr[left] > arr[i]) {
            greater = left;
        }
        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }
        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
