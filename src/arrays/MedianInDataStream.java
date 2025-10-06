package arrays;

import java.util.PriorityQueue;

/*
LC#295: Find Median from Data Stream.

 */
public class MedianInDataStream {
    public static void main(String[] args) {

        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        double median = obj.findMedian();
        System.out.println(median);
    }
}

/*
use two priority queues one upper and one to hold lower with utmost size difference of 2 elements
To find median, use top two numbers from each pq.
 */
class MedianFinder {

    PriorityQueue<Integer> upper;
    PriorityQueue<Integer> lower;

    public MedianFinder() {
        upper = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        lower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {

        if (!upper.isEmpty() && num >= upper.peek()) {
            upper.add(num);
        } else {
            lower.add(num);
        }

        // rebalance
        System.out.println("b4 rebalance upper peek ==> " + upper.peek() + " lower peek ==> " + lower.peek());

        if (upper.size() - lower.size() == 2) {
            lower.add(upper.peek());
            upper.poll();
        } else if (lower.size() - upper.size() == 2) {
            upper.add(lower.peek());
            lower.poll();
        }

        System.out.println("after rebalance upper peek ==> " + upper.peek() + " lower peek ==> " + lower.peek());

    }

    public double findMedian() {
        System.out.println("upper peek ==> " + upper.peek() + " lower peek ==> " + lower.peek());
        if (upper.size() == lower.size()) {
            return (double) (upper.peek() + lower.peek()) / 2;
        } else if (upper.size() > lower.size()) {
            return upper.peek();
        } else {
            return lower.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */