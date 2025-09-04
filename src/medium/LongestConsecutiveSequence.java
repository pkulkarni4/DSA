package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:

Input: nums = [1,0,1,2]
Output: 3

 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        LongestConsecutiveSequenceSolution s = new LongestConsecutiveSequenceSolution();
        int ans = s.longestConsecutive(nums);
        System.out.println("ans from old soln: "+ans);

        NewSolution ns = new NewSolution();
        ans = ns.longestConsecutive(nums);
        System.out.println("ans from new soln: "+ans);

    }
}
class LongestConsecutiveSequenceSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet =  new HashSet<>();
        for(int num: nums){
            numsSet.add(num);
        }
        int maxSeq = 0, len = 0;
        for(int n : numsSet){
            // no left neighbor, make a sequence
            if(!numsSet.contains(n-1)){
                len = 1;
                while(numsSet.contains(n+len)) {
                    len++;
                }
                maxSeq = Math.max(len, maxSeq);
            }
        }

        return maxSeq;
    }
}
class NewSolution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : seen) {
            // `num` is the start of a sequence.
         //   if (seen.contains(num - 1))
         //       continue;
            int length = 1;
            while (seen.contains(++num))
                ++length;
            ans = Math.max(ans, length);
        }

        return ans;
    }
}
