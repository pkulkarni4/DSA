package arrays.medium;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ArrayProductSelf238 {

    public static void main(String[] args) {
        SolutionArrayProductSelf238 s = new SolutionArrayProductSelf238();
        int[] arr = new int[] {1,2,3,4,5};
        prod(s, arr);
        System.out.println("\n----");
        arr = new int[] {1,2,3,4, 0};
        prod(s, arr);
        System.out.println("\n----");
        arr = new int[] {1,2,0,4,3};
        prod(s, arr);
    }

    private static void prod(SolutionArrayProductSelf238 s, int[] arr) {
        int[] p = s.productExceptSelf(arr);
        for(int i: p){
            System.out.print(i +"\t");
        }
    }


}

class SolutionArrayProductSelf238 {
    private void print(int[] p) {
        for(int i: p){
            System.out.print(i +"\t");
        }
    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right=new int[len];
        left[0]=1;
        right[len-1]=1;

        // fill left arr with prod
        for(int i=1;i<len;i++) {
            left[i] = left[i-1] * nums[i-1];
        }
print(left);
        // fill right prod
        for(int i=len-2;i>=0;i--) {
            right[i]=right[i+1]*nums[i+1];
        }
print(right);
        // prod
        int[] prod = new int[len];
        for(int i=0;i<len;i++){
            prod[i]=left[i]*right[i];
        }
        return prod;
    }
        public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int curr =1;
        for(int i=0;i<len;i++){
            res[i] = curr;
            curr*=nums[i];
        }

        print(res);

        curr=1;
        for(int i=len-1;i>=0;i--) {
            res[i]*=curr;
            curr*=nums[i];
        }

        return res;

    }
}
