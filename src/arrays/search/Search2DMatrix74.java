package arrays.search;

/*
LC#74: search in sorted 2d matrix.

 */
public class Search2DMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 13;
        Search2DMatrix74Solution sol = new Search2DMatrix74Solution();
        boolean b = sol.searchMatrix(matrix, target);
        System.out.println(b);
    }
}

class Search2DMatrix74Solution {
    /*
    Visualize matrix as an array - arr[0][0] to be arr[0] (left) and arr[m][n] to be arr[len] (right), mid will be
    (left+right)/2
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = (rows * cols) - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            // System.out.println("row: ==>" + mid / cols + " col: ==> "+mid%cols+" mid ele ==> " + midElement);
            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
