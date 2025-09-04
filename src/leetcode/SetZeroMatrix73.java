package leetcode;

public class SetZeroMatrix73 {
    public static void main(String[] args) {
        SolutionSetZeroMatrix73 s = new SolutionSetZeroMatrix73();
        //int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; //{{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{4, 1, 2, 9}, {8, 4, 5, 2}, {0, 3, 1, 5}}; //{{1,1,1},{1,0,1},{1,1,1}};

        printMatrix(matrix);
        s.setZeroes(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class SolutionSetZeroMatrix73 {
    public void setZeroes(int[][] matrix) {
        int col = matrix.length, row = matrix[0].length;
        boolean doesFirstRowHaveZero = false, doesFirstColHaveZero = false;

        // chk for 1st row
        for (int i = 0; i < row; i++) {
            if (matrix[0][i] == 0) {
                doesFirstRowHaveZero = true;
                break;
            }
        }
        //chk for 1st col
        for (int i = 0; i < col; i++) {
            if (matrix[i][0] == 0) {
                doesFirstColHaveZero = true;
                break;
            }
        }

        // check the rest of the matrix for zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                nullifyCol(matrix, i);
            }
        }

        if (doesFirstColHaveZero) {
            nullifyCol(matrix, 0);
        }

        if (doesFirstRowHaveZero) {
            nullifyRow(matrix, 0);
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
