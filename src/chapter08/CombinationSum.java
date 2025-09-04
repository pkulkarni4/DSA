package chapter08;

import java.util.ArrayList;
import java.util.List;

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
        list = new ArrayList<>();
        current = new ArrayList<>();
        findUniqueCombinationTargetSum(candidates, target, 0, list, current, 0);
        System.out.println(list);
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
