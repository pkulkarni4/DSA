package arrays.heap;

import java.util.*;

/*
LC # 506. Relative ranks
Top 3 ranks will be labeled as "Gold Medal", "Silver Medal", "Bronze Medal" and rest of them will be number of rank.

input scores = [5,4,3,2,1]
output = ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]

scores = [10,3,8,9,4]
output = ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
*/
public class RelativeRanks506 {
    public static void main(String[] args) {

        int[][] examples = {
                {1, 2, 3, 4, 5},
                {5, 4, 3, 2, 1},
                {10, 3, 8, 9, 4}
        };
        RelativeRanks506Solution s = new RelativeRanks506Solution();
        for (int[] input : examples) {
            String[] res = s.findRelativeRanks(input);
            printStringArray(res);
        }
    }

    static void printStringArray(String[] res) {
        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}

class RelativeRanks506Solution {
    /*
    use priority queue to keep the score sorted in descending order

     */
    public String[] findRelativeRanks(int[] scores) {
        int length = scores.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int score: scores) {
            pq.add(score);
        }

        Map<Integer, Integer> scoreMap = new HashMap<>();

        int count = 1;
        while(!pq.isEmpty()) {
            scoreMap.put(pq.poll(), count);
            count++;
        }

        String[] res = new String[length];
        int score = 0;
        while(score < length){
            if(scoreMap.get(scores[score]) == 1) {
                res[score] = "Gold Medal";
            } else if(scoreMap.get(scores[score]) == 2) {
                res[score] = "Silver Medal";
            } else if(scoreMap.get(scores[score]) == 3){
                res[score] = "Bronze Medal";
            } else {
                res[score] = scoreMap.get(scores[score]).toString();
            }
            score++;
        }
        return res;
    }
}