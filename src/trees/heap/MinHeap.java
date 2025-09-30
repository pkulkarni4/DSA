package trees.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {

    private static final int DEFAULT_CAPACITY = 5;
    private int size;
    private T[] heap;
    private int capacity;

    public MinHeap() {
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
        System.out.println("ROOT : " + heap[0]);
        for (int i = 0; i < size; i++) {
            System.out.print("\tNODE: " + heap[i]);
            if (hasLeftChild(i)) {
                System.out.print("\t LEFT : " + leftChild(i));
            }
            if (hasRightChild(i)) {
                System.out.print("\t RIGHT : " + rightChild(i));
            }
            System.out.println();
        }
        System.out.println(" ******* ");
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && heap[index].compareTo(parent(index)) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallestChildIndex = getRightChildIndex(index);
            }
            if (heap[index].compareTo(heap[smallestChildIndex]) > 0) {
                swap(index, smallestChildIndex);
            } else {
                break;
            }
            index = smallestChildIndex;
        }
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private T rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private T leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private T parent(int index) {
        return heap[getParentIndex(index)];
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity = capacity * 2;
            heap = Arrays.copyOf(heap, capacity);
        }
    }
}
