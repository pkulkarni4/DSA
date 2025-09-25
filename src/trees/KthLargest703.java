package trees;

import java.util.PriorityQueue;

/*
LC # 703: Kth Largest Element in a Stream

 */
public class KthLargest703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println("add 3 : " + kthLargest.add(3));
        System.out.println("add 5 : " + kthLargest.add(5));
        System.out.println("add 10 : " + kthLargest.add(10));
        System.out.println("add 9: " + kthLargest.add(9));
        System.out.println("add 4: " + kthLargest.add(4));

    }
}

class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);
        for(int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}