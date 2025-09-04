package arrays;

/*
Problem: Consider that you've been given a matrix, m x n, containing only 0 and 1 (binary matrix).
Write a snippet of code that returns the maximum size of the SQUARE sub-matrix so that it contains ONLY elements of 1.

ex:
matrix = {
            {1, 1, 1},
            {1, 1, 0},
            {0, 0, 1}
}

create a dp array with size + 1
update dp[i][j] with
    0 if matrix[i][j] == 0
    otherwise min (matrix[i][j+1], matrix[i+1][j], matrix[i-1][j-1]) + 1

return max number in dp

dp = {
        {0, 0, 0, 0},
        {1, 1, 0, 0},
        {1, 2, 0, 0},
        {1, 2, 1, 1},
}
max is 2,
---

matrix = {
         {0,0,1,1,0,0,0},
         {0,0,1,1,1,1,1},
         {1,1,0,0,1,1,1},
         {1,1,0,0,1,1,1},
         {0,1,1,0,0,0,0},
}

dp = {
         {0, 0, 1, 1, 0, 0, 0},
         {0, 0, 1, 1, 1, 1, 1},
         {1, 1, 0, 0, 1, 2, 2},
         {1, 2, 0, 0, 1, 2, 3},
         {0, 1, 1, 1, 1, 2, 3},
}

track the max element in dp is 3

 */
public class SubMatrixOf1 {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 0},
        };
        int rows = matrix.length, cols = matrix[0].length;
        SubMatrixOf1Solution s = new SubMatrixOf1Solution();
        int maxSubArraySize = s.maximalSquare(matrix, rows, cols);
        System.out.println(maxSubArraySize);

        int[][] matrix3 = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int rows3 = matrix3.length, cols3 = matrix3[0].length;
        maxSubArraySize = s.maximalSquare(matrix3, rows3, cols3);
        System.out.println(maxSubArraySize);

        char[][] matrix2 = {
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }
        };

        int rows2 = matrix2.length, cols2 = matrix2[0].length;

       int maxSubArraySize2= s.maximalSquare(matrix2, rows2, cols2);
        System.out.println(maxSubArraySize2);

        char[][] matrix4 = {
                {'0'}
        };

        int rows4 = matrix4.length, cols4 = matrix4[0].length;
        int maxSubArraySize4= s.maximalSquare(matrix4, rows4, cols4);
        System.out.println(maxSubArraySize4);
    }
}

class SubMatrixOf1Solution {
    public int maximalSquare(char[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        int maxMatrixSize = 0;
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] - '0' == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    maxMatrixSize = Math.max(dp[i][j], maxMatrixSize);
                }
            }
        }
      // print2DArray(dp, rows, cols);
        return maxMatrixSize * maxMatrixSize;
    }

    void print2DArray(int[][] dp, int rows, int cols) {
        System.out.println("[");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public int maximalSquare(int[][] matrix, int rows, int cols) {
        int[][] dp = new int[rows][cols];
        int maxMatrixSize = 1;

        // copy first row and col from matrix to dp
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    maxMatrixSize = Math.max(maxMatrixSize, dp[i][j]);
                }
            }
        }
        return maxMatrixSize * maxMatrixSize;
    }
}