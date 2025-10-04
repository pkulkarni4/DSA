package arrays;

public class MaxDifference {
    public static void main(String[] args) {
        int[][] examples = {
                {7, 1, 5, 4},
                {9, 4, 3, 2},
                {1, 5, 2, 10},
                {1, 34, 21, 7, 4, 8, 10},
                {17, 9, 2, 26, 32, 27, 3},
                {999, 997, 980, 976, 948, 940, 938, 928, 924, 917, 907, 907, 881, 878, 864, 862, 859, 857, 848, 840, 824, 824, 824, 805, 802, 798, 788, 777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454, 449, 438, 425, 403, 368, 345, 327, 287, 285, 270, 263, 255, 248, 235, 234, 224, 221, 201, 189, 187, 183, 179, 168, 155, 153, 150, 144, 107, 102, 102, 87, 80, 57, 55, 49, 48, 45, 26, 26, 23, 15}
        };
        MaxDifference2016Solution sol = new MaxDifference2016Solution();
        for (int[] input : examples) {
            int maxDiff = sol.maximumDifference(input);
            System.out.println(maxDiff);
        }
    }
}

class MaxDifference2016Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int maxDiff = nums[1] - nums[0];
        int marker = nums[0];
        for (int i = 1; i < len; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - marker);
            marker = Math.min(nums[i], marker);
        }
        return maxDiff <= 0 ? -1 : maxDiff;
    }
}
