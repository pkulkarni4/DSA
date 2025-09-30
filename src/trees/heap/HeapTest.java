package trees.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(4);
        maxHeap.add(5);

        maxHeap.print();

        System.out.println(maxHeap.peek());
        maxHeap.poll();
        System.out.println(maxHeap.peek());
        maxHeap.poll();
        System.out.println(maxHeap.peek());
        maxHeap.poll();
        System.out.println(maxHeap.peek());
        maxHeap.poll();
        System.out.println(maxHeap.peek());
        maxHeap.poll();
        //System.out.println(maxHeap.peek()); This will throw NoSuchElement Exception

        maxHeap.print();

        System.out.println(" ******* ");

        Heap<Integer> minHeap = new MinHeap<>();
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);

        minHeap.print();

        System.out.println(minHeap.peek());
        minHeap.poll();
        System.out.println(minHeap.peek());
        minHeap.poll();
        System.out.println(minHeap.peek());
        minHeap.poll();
        System.out.println(minHeap.peek());
        minHeap.poll();
        System.out.println(minHeap.peek());
        minHeap.poll();
        // System.out.println(maxHeap.peek()); This will throw NoSuchElement Exception

        minHeap.print();

    }
}
