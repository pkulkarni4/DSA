package arrays;

import java.util.*;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {
    public static void main(String[] args) {

        int[][] examples = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0}
        };
        for (int i = 0; i < examples.length; i++) {
            List<List<Integer>> lists = threeSum(examples[i]);
            for(List<Integer> ls : lists) {

                for(Integer in : ls) {
                    System.out.print(in + " ");
                }
                System.out.println();
            }

        }
    }

    static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums == null) return null;
        int len = nums.length;
        if (len < 3) return null;

        Arrays.sort(nums);

        Set<Triplet> tripletSet = getTripletSet(nums, len);

        for (Triplet t1 : tripletSet) {
            List<Integer> l = new ArrayList<>();

            l.add(t1.getVal1());
            l.add(t1.getVal2());
            l.add(t1.getVal3());

            lists.add(l);
        }
        return lists;
    }

    private static Set<Triplet> getTripletSet(int[] nums, int len) {
        Set<Triplet> tripletSet = new HashSet<>();

        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    Triplet t = new Triplet(nums[i], nums[left], nums[right]);
                    tripletSet.add(t);
                    left++;
                    right--;
                } else if (target < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return tripletSet;
    }
}

class Triplet {
    private int val1;
    private int val2;
    private int val3;

    public Triplet(int val1, int val2, int val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    public int getVal3() {
        return val3;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triplet triplet)) return false;
        return val1 == triplet.val1 && val2 == triplet.val2 && val3 == triplet.val3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val1, val2, val3);
    }
}