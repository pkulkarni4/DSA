package chapter08;

import java.util.ArrayList;
import java.util.List;

/*
LC: 39 Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
Example:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int len = candidates.length;
        int target = 7;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        findAllCombinationsTargetSum(candidates, len, target, list, current, 0);
        System.out.println(list);

        // reset
        int[][] examples = {
                {2, 3, 6, 7},
                {2,3,5}
        };
        int[] targets= {7, 8};
        for(int i =0;i<examples.length;i++) {
            list = new ArrayList<>();
            current = new ArrayList<>();
            findUniqueCombinationTargetSum(examples[i], targets[i], 0, list, current, 0);
            System.out.println(list);
        }
    }

    static void findAllCombinationsTargetSum(int[] candidates, int len, int target, List<List<Integer>> list, List<Integer> current, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(current));
        }
        for (int i = 0; i < len; i++) {
            if (target < candidates[index]) {
                continue;
            }
            current.add(candidates[i]);
            findAllCombinationsTargetSum(candidates, len, target - candidates[i], list, current, i);
            current.removeLast();
        }
    }

    static void findUniqueCombinationTargetSum(int[] candidates, int target, int currentSum, List<List<Integer>> list, List<Integer> current, int index) {
        if (target == currentSum) {
            list.add(new ArrayList<>(current));
            return;
        }
        if (index < candidates.length && target > currentSum) {
            current.add(candidates[index]);
            findUniqueCombinationTargetSum(candidates, target, currentSum + candidates[index], list, current, index);
            current.removeLast();
            findUniqueCombinationTargetSum(candidates, target, currentSum, list, current, index + 1);
        }
    }
}
