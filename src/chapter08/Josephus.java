package chapter08;

import java.util.ArrayDeque;
import java.util.Queue;

public class Josephus {
    public static void main(String[] args) {
        int n = 15, k = 3;
        int survivor = josephus(n, k);
        System.out.println(survivor);
    }

    static int josephus(int n, int k) {
        Queue<Integer> circle = new ArrayDeque<>();

        for(int i=1;i<=n; i++) {
            circle.add(i);
        }

        while(circle.size() != 1) {
            for(int i=1;i<=k;i++) {
                // Retrieves and removes the head of this queue
                int eliminated = circle.poll();
                if(i==k) {
                    System.out.println("Eliminated: " + eliminated);
                    break;
                }
                circle.add(eliminated);
            }
        }
        // Retrieves, but does not remove, the head of this queue
        return circle.peek();
    }

}
