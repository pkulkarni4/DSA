package arrays.heap;

import java.util.PriorityQueue;

/*
 LC # 1464: Max product of two elements in an array
 Given array of integers nums, choose different indices i and j, return max of (nums[i] - 1 * nums[j] - 1)
 ex:
 Input: nums = [3,4,5,2]
 Output: 12
 */
public class MaxProductTwoElements1464 {
    public static void main(String[] args) {
        int[][] examples = {
                {3, 4, 5, 2},
                {1, 5, 4, 5},
                {3, 7}
        };
        MaxProductTwoElements1464Solution s = new MaxProductTwoElements1464Solution();
        for (int i = 0; i < examples.length; i++) {
            int maxProd = s.maxProductPQ(examples[i]);
            System.out.println("max product:  " + maxProd);
        }
    }
}

class MaxProductTwoElements1464Solution {
    public int maxProductPQ(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> (i - 1) * (j - 1));
        for (int n : nums) {
            pq.add(n);
        }
        return pq.poll();
    }

    public int maxProduct(int[] nums) {
        int maxProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                int prod = (nums[i] - 1) * (nums[j] - 1);
                // System.out.println("nums["+i+"] - 1 * nums ["+j+ "] -1 = " + prod);
                maxProduct = Math.max(maxProduct, prod);
            }
        }
        return maxProduct;
    }
}