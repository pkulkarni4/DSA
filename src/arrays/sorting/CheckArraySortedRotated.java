package arrays.sorting;

/*
LC#1752: Check if array is sorted and rotated
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.


 */
public class CheckArraySortedRotated {
    public static void main(String[] args) {
        int[][] examples = {
                {3, 4, 5, 1, 2},
                {2, 1, 3, 4},
                {1, 2, 3},
                {3, 4, 6, 1, 2, 5}
        };
        CheckArraySortedRotated1752 sol = new CheckArraySortedRotated1752();
        for (int[] input : examples) {
            boolean b = sol.check(input);
            System.out.println("is sorted and rotated ? ==> " + b);
        }
    }
}

class CheckArraySortedRotated1752 {
    public boolean check(int[] nums) {
        int count = 0;
        int length = nums.length;
        for(int i = 0; i< length; i++){
            if(nums[i] > nums[ (i+1) % length]){
                count++;
            }
        }
        return count <= 1;
    }
}