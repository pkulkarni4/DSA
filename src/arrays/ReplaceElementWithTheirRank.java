package arrays;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ReplaceElementWithTheirRank {
    public static void main(String[] args) {


        int[] m = {100, 5, 70, 2};
        int len = m.length;
        replaceWithRankUsingTreemap(len, m);

        System.out.println("Treemap: " + java.util.Arrays.toString(m));
        int[] res = replaceWithRankUsingPQ(len, m);
        System.out.println("PQ: " + java.util.Arrays.toString(m));

    }

    static int[] replaceWithRankUsingPQ(int len, int[] m) {
        int[] res = new int[len];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<len;i++) {
            pq.add(new int[]{m[i], i});
        }
        int rank = 0, lastNum = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int curr = top[0];
            int index = top[1];
            if(lastNum == Integer.MAX_VALUE || curr != lastNum) {
                rank++;
            }
            res[index] = rank;
            lastNum = curr;
        }
        return res;
    }

    static void replaceWithRankUsingTreemap(int len, int[] m) {
        Map<Integer, Integer> treemap = new TreeMap<>();
        for(int i = 0; i< len; i++){
            treemap.put(m[i], i);
        }
        int rank = 1;
        for(Map.Entry<Integer, Integer> entry: treemap.entrySet()){
            m[entry.getValue()] = rank++;
        }
    }
}
