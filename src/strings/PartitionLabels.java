package strings;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels763Solution sol = new PartitionLabels763Solution();
        String[] input = {
                "aab",
                "ababcbacadefegdehijhklij",
                "eccbbbbdec",
                "abc"
        };
        for (String in : input) {
            List<Integer> res = sol.partitionLabels(in);
            for (Integer i : res) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class PartitionLabels763Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        int maxReach = 0;
        int partitionStart = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            maxReach = Math.max(maxReach, lastOccurrence[s.charAt(i) - 'a']);
            if (maxReach == i) {
                res.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return res;
    }
}