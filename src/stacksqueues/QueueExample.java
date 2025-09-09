package stacksqueues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/*Queue interface offers following methods, concrete classes include: ArrayDeque, PriorityQueue, LinkedList, etc
add(element): Adds an element to the rear of the queue. If the queue is full, it throws an exception.
offer(element): Adds an element to the rear of the queue. If the queue is full, it returns false.
remove(): Removes and returns the element at the front of the queue. If the queue is empty, it throws an exception.
poll(): Removes and returns the element at the front of the queue. If the queue is empty, it returns null.
element(): Returns the element at the front of the queue without removing it. If the queue is empty, it throws an exception.
peek(): Returns the element at the front of the queue without removing it. If the queue is empty, it returns null.

 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(5);
        // returns null
        System.out.println("peek: " + queue.peek());
        System.out.println("poll: " + queue.poll());
        // both remove and element methods throw exception
        // System.out.println(queue.remove());
        // System.out.println(queue.element());
        queue.add(14);
        queue.add(13);
        queue.add(12);
        queue.add(11);
        System.out.println("queue: " + queue);
        System.out.println("peek(): " + queue.peek());
        System.out.println("element(): " + queue.element());
        System.out.println("offer (15): " + queue.offer(15));
        System.out.println("queue:" + queue);
        System.out.println("remove(): " + queue.remove());
        System.out.println("queue:" + queue);
        // iterate queue:
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
