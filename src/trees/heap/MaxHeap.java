package trees.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private int capacity;
    private int size;
    private T[] heap;

    public MaxHeap() {
        capacity = DEFAULT_CAPACITY;
        this.heap = (T[]) Array.newInstance(Comparable[].class.componentType(), DEFAULT_CAPACITY);

    }

    @Override
    public void add(T element) {
        ensureCapacity();
        heap[size++] = element;

        heapifyUp();
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    @Override
    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T elem = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        heapifyDown();

        return elem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.println(" ******* ");
        if (size == 0) {
            System.out.println("EMPTY HEAP");
            return;
        }
        System.out.print("ROOT: " + heap[0] + "\n");
        for (int i = 0; i < size; i++) {
            System.out.print("\tNODE: " + heap[i]);
            if (hasLeftChild(i)) {
                System.out.print("\tLEFT NODE: " + leftChild(i));
            }
            if (hasRightChild(i)) {
                //System.out.print("\tRIGHT NODE: " + heap[getRightChildIndex(i)]);
                System.out.print("\tRIGHT NODE: " + rightChild(i));
            }
            System.out.println();
        }
        System.out.println(" ******* ");
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity = capacity * 2;
        }
    }

    private void heapifyUp() {
        // step 1: start from the end of the heap as the current node
        int index = size - 1;
        // step 2: as long as current node has a parent and parent is less than the current node, swap these nodes
        while (hasParent(index) && parent(index).compareTo(heap[index]) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        // step 1: start from the root of the heap as current node
        int index = 0;
        while (hasLeftChild(index)) {
            // step 2: determine the largest node between the children of the current node
            int largestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) > 0) {
                largestChildIndex = getRightChildIndex(index);
            }
            // step 3: if the current node is smaller than its largest child then swap these two nodes
            if (heap[index].compareTo(heap[largestChildIndex]) < 0) {
                swap(index, largestChildIndex);
            } else {
                // nothing to do , so stop
                break;
            }
            index = largestChildIndex;
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private T parent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private T rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private T leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private void swap(int parentIndex, int childIndex) {
        T temp = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = temp;
    }
}
