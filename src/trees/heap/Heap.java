package trees.heap;

public interface Heap<T extends Comparable<T>> {
    void add(T element);

    T peek();

    T poll();

    int size();

    void print();
}
