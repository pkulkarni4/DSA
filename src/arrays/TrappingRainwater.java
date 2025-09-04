package arrays;

/*

Consider that you've been given a set of bars that are different heights (non-negative integers). The width of a bar is equal to 1.

Write a snippet of code that computes the amount of water that can be trapped within the bars.

Example:
height= {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3}, output = 16
height = {0,1,0,2,1,0,1,3,2,1,2,1}, output = 6
height = {4,2,0,3,2,5}, output = 9
 */
public class TrappingRainwater {
    public static void main(String[] args) {
        int[][] examples = {
                {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3},
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {4, 2, 0, 3, 2, 5}
        };
        SolutionTW s = new SolutionTW();
        for (int i = 0; i < examples.length; i++) {
            int water = s.trap(examples[i]);
            System.out.println(water);
        }
    }
}

class SolutionTW {
    public int trap(int[] height) {
        int len = height.length - 1, water = 0;
        int[] left = new int[len];
        left[0] = Integer.MIN_VALUE;
        for(int i = 1; i<len; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        int right = Integer.MIN_VALUE;
        for(int i = len-1; i >= 1; i--){
            right = Math.max(right, height[i+1]);
            int min = Math.min(left[i], right);
            if(min > height[i]) {
                water += min - height[i];
            }
        }
        return water;
    }
}

class TrappingRainwaterSolution {
    public int trap(int[] height) {
        int len = height.length - 1, water = 0;
        int[] left = new int[len];
        left[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int right = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 1; i--) {
            right = Math.max(right, height[i + 1]);
            int min = Math.min(left[i],
                    right);
            if (min > height[i]) {
                water += min - height[i];
            }
        }
        return water;
    }
}