package arrays;

/*
Problem: Consider that you've been given n positive integers, p1, p2, ..., pn, where each integer represents a point at coordinate (i, pi).
Next, n vertical lines are drawn so that the two endpoints of line i are at (i, pi) and (i, 0).
Write a snippet of code that finds two lines that, together with the X-axis, form a container that contains the most water.

Example:
n = [1, 3, 5, 4];
Point p1 = (0, 1), p2 = (1, 3), p3 = (2, 5), p4 = (3,4)
Point p11 = (0, 0), p22 = (1, 0), p33 = (2, 0), p44 = (3, 0)

5 +              *
  |
4 +                   *
  |
3 +         *
  |
2 +
  |
1 +    *
  |____+____+____+____+____
       0    1    2    3

  if pi < pj i++
  else j++
  calculate area
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWaterSolution s = new ContainerWithMostWaterSolution();
        int[] heights = {1, 4, 6, 2, 7, 3, 8, 5, 3};
        int maxArea = s.maxAreaTwoPointers(heights);
        System.out.println(maxArea);

        maxArea = s.maxArea(heights);
        System.out.println(maxArea);
    }
}

class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    public int maxAreaTwoPointers(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}