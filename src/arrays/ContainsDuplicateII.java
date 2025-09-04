package arrays;

import java.util.HashSet;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        SolutionContainsDuplicateII s = new SolutionContainsDuplicateII();
        int[][] examples = {
                {1, 2, 3, 1},
                {1, 0, 1, 1},
                {1, 2, 3, 1, 2, 3}
        };
        int[] k = {3, 1, 2};
        for (int i = 0; i < examples.length; i++) {
            boolean b = s.containsNearbyDuplicateBruteForce(examples[i], k[i]);
            System.out.println(b);
        }

        System.out.println("***");

        for (int i = 0; i < examples.length; i++) {
            boolean b = s.containsNearbyDuplicate(examples[i], k[i]);
            System.out.println(b);
        }

        SolutionContainsDuplicateIII s3 = new SolutionContainsDuplicateIII();
        boolean s3b = s3.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
        System.out.println(s3b);

        s3b = s3.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        System.out.println(s3b);
    }
}

class SolutionContainsDuplicateIII {
    /*
        You are given an integer array nums and two integers indexDiff and valueDiff.

        Find a pair of indices (i, j) such that:

        i != j,
        abs(i - j) <= indexDiff.
        abs(nums[i] - nums[j]) <= valueDiff, and
        Return true if such pair exists or false otherwise.

        Example 1:

        Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
        Output: true
        Explanation: We can choose (i, j) = (0, 3).
        We satisfy the three conditions:
        i != j --> 0 != 3
        abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
        abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

        Example 2:

        Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
        Output: false
        Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }
}

class SolutionContainsDuplicateII {
    public boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
