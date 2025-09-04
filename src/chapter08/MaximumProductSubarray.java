package chapter08;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {3, 5, -2, -3, 2, -4, 7};
        MaximumProductSubarraySolution s = new MaximumProductSubarraySolution();
        int maxProd = s.getMaximumProductSubarray(nums);
        System.out.println(maxProd);
    }
}

class MaximumProductSubarraySolution {

    int getMaximumProductSubarray(int[] nums) {
        int len = nums.length;
        int leftProduct = 1, rightProduct = 1;
        int maxProduct = nums[0];

        for (int i = 0; i < len; i++) {
            if (leftProduct == 0) {
                leftProduct = 1;
            }
            if (rightProduct == 0) {
                rightProduct = 1;
            }
            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[len - 1 - i];

            maxProduct = Math.max(Math.max(leftProduct, rightProduct), maxProduct);
        }

        return maxProduct;
    }
}