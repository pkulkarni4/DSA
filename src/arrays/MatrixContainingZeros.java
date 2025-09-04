package arrays;

import java.util.ArrayList;
import java.util.List;

public class MatrixContainingZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 0},
                {2, 3, 1, 5, 7},
                {2, 3, 4, 5, 7},
                {2, 3, 4, 2, 7},
                {0, 3, 9, 5, 7}
        };
        int rows = matrix.length, cols = matrix[0].length;

        setZeroMatrixUsingExtraSpace(matrix, rows, cols);
        printMatrix(rows, cols, matrix);

        int[][] matrix1 = {
                {1, 2, 3, 4, 0},
                {2, 3, 1, 5, 7},
                {2, 3, 4, 5, 7},
                {2, 3, 4, 2, 7},
                {0, 3, 9, 5, 7}
        };
        setZeroMatrixWithoutUsingExtraSpace(matrix1, rows, cols);

        printMatrix(rows, cols, matrix);
    }

    private static void printMatrix(int rows, int cols, int[][] matrix) {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void setZeroMatrixWithoutUsingExtraSpace(int[][] matrix, int rows, int cols) {
        boolean doesFirstRowHaveZero = false, doesFirstColumnHaveZero = false;


        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                doesFirstRowHaveZero = true;
                break;
            }
        }

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                doesFirstColumnHaveZero = true;
                break;
            }
        }

        // mar
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < cols; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // now update the first row and column to zero, if applicable
        if (doesFirstRowHaveZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (doesFirstColumnHaveZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    static void setZeroMatrixUsingExtraSpace(int[][] matrix, int rows, int cols) {
        List<Integer> nullifyRows = new ArrayList<>();
        List<Integer> nullifyCols = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    nullifyRows.add(i);
                    nullifyCols.add(j);
                }
            }
        }

        for (Integer row : nullifyRows) {
            for (int i = 0; i < cols; i++) {
                matrix[row][i] = 0;
            }
        }

        for (Integer col : nullifyCols) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
    }

}
