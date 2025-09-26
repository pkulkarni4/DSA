package arrays.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public static void main(String[] args) {
        LastStoneWeight1046Solution s = new LastStoneWeight1046Solution();
        int[][] examples = {
                {2, 7, 4, 1, 8, 1},
                {1}
        };
        for (int i = 0; i < examples.length; i++) {
            int res = s.lastStoneWeight(examples[i]);
            System.out.println(res);
        }
    }
}

class LastStoneWeight1046Solution {

    /*
    use max heap to get the heaviest stones to smash.
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            pq.offer(i);
        }

        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}