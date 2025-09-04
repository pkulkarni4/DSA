package others;

import java.util.List;

public class GenerateAllSubarrays {
    public static void main(String[] args) {
        int[] nums = {5,7,-3,2,2};
        GenerateAllSubarraysSolution s = new GenerateAllSubarraysSolution();
        List<List<Integer>> res = s.generateAllSubarrays(nums);
    }
}

class GenerateAllSubarraysSolution {
    public List<List<Integer>> generateAllSubarrays(int[] nums) {

        int len = nums.length;
        for(int i=0;i<len-1;i++) {
            for(int j=i+1;j<len;j++) {
                System.out.println();
            }
        }
        return null;
    }
}