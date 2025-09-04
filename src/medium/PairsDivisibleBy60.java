package medium;

import java.util.HashMap;
import java.util.Map;

public class PairsDivisibleBy60 {
    public static void main(String[] args) {
        int[] nums = {30, 20, 150, 100, 40};
        PairsDivisibleBy60Solution s = new PairsDivisibleBy60Solution();
        int count = s.numPairsDivisibleBy60(nums);
        System.out.println("pairs: " + count);

        count = s.numPairsDivisibleBy60(new int[] {60,60,60});
        System.out.println("pairs: " + count);
    }
}

class PairsDivisibleBy60Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int nums : time){
            int key = 60 - nums % 60;
            count += map.getOrDefault(key, 0);
            map.put(nums % 60, map.getOrDefault(key, 0)+1);
        }

        return count;
    }
}