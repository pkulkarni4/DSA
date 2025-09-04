package chapter08;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingTemplate {
    public static void main(String[] args) {

    }
}
class BacktrackingTemplateSolution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;

    public  List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);
        return list;
    }

    public void backtrack(int index, List<Integer> current) {
        if(index == nums.length) {
            list.add(new ArrayList<>(current));
        }
        current.add(nums[index]);
        backtrack(index+1, current);
        current.remove(current.size() - 1);
        backtrack(index+1, current);
    }
}