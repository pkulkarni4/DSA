package arrays;

/*
Problem: Imagine that you have k sorted arrays of different lengths.
Write an application that merges these arrays into O(nk log n), where n is the length of the longest array.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[][] arrs = {
                {1, 2, 32, 46},
                {-4, 5, 15, 18, 20},
                {3, 4},
                {6, 8},
                {-2, -1, 0}
        };
        MergeSortedArraysSolution s = new MergeSortedArraysSolution();
        int[] result = s.mergeUsingPriorityQueue(arrs);
        System.out.println(Arrays.toString(result));

        int k = 3;
        result = s.mergeUsingMinHeap(arrs, 5);
        System.out.println(Arrays.toString(result));

    }
}

class MinHeap {
    int data;
    int heapIndex;
    int currentIndex;

    public MinHeap(int data, int heapIndex, int currentIndex) {
        this.data = data;
        this.heapIndex = heapIndex;
        this.currentIndex = currentIndex;
    }

    @Override
    public String toString() {
        return data + "";
    }
}

class MergeSortedArraysSolution {

    public int[] mergeUsingMinHeap(int[][] arrs, int k) {
        int len = 0;
        int arrLen = arrs.length;
        for (int i = 0; i < arrLen; i++) {
            len += arrs[i].length;
        }
        int[] result = new int[len];

        MinHeap[] heap = new MinHeap[k];
        // add first element from each array to heap
        for (int i = 0; i < k; i++) {
            heap[i] = new MinHeap(arrs[i][0], i, 0);
        }

        // merge
        for (int i = 0; i < result.length; i++) {
            heapify(heap, 0, k);
            // add element to result
            result[i] = heap[0].data;
            heap[0].currentIndex++;
            int[] subarray = arrs[heap[0].heapIndex];
            if (heap[0].currentIndex >= subarray.length) {
                heap[0].data = Integer.MAX_VALUE;
            } else {
                heap[0].data = subarray[heap[0].currentIndex];
            }
        }
        return result;
    }

    void heapify(MinHeap[] heap, int root, int len) {
        int smallest = root;
        int leftIndex = left(root);
        int rightIndex = right(root);

        if (leftIndex < len && heap[smallest].data > heap[leftIndex].data) {
            smallest = leftIndex;
        }
        if (rightIndex < len && heap[smallest].data > heap[rightIndex].data) {
            smallest = rightIndex;
        }
        if (smallest != root) {
            swap(heap, smallest, root);
            heapify(heap, smallest, len);
        }
    }

    void swap(MinHeap[] heap, int i, int j) {
        MinHeap aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    /*
    Uses java.util.PriorityQueue for minHeap and maxHeap.
     */
    public int[] mergeUsingPriorityQueue(int[][] arrs) {
        PriorityQueue<Integer> minHeapPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapPQ = new PriorityQueue<>(10, (a, b) -> b - a);
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                minHeapPQ.add(arrs[i][j]);
                maxHeapPQ.add(arrs[i][j]);
            }
        }
        int[] res = new int[minHeapPQ.size()];
        int count = 0;
        while (!minHeapPQ.isEmpty()) {
            res[count++] = minHeapPQ.poll();
        }

        // print max hq
        while (!maxHeapPQ.isEmpty()) {
            System.out.print(maxHeapPQ.poll() + " ");
        }
        System.out.println();

        return res;
    }
}