package leetcode;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        SolutionTransposeMatrix867 s = new SolutionTransposeMatrix867();
        int[][] matrix1 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix2 = {{5,1,9},{2,4,8},{13,3,6},{15,14,12}};
        int[][] matrix = {{5,1},{2,4}};
        //System.out.println("matrix.length: " + matrix.length +"   matrx[0].length:  "+ matrix[0].length);
        printMatrix(matrix);
        int[][] transposed = s.transform_90_degree(matrix);
        printMatrix(transposed);
         transposed = s.transform_90_degree(transposed);
        printMatrix(transposed);
        transposed = s.transform_90_degree(transposed);
        printMatrix(transposed);
        transposed = s.transform_90_degree(transposed);
        printMatrix(transposed);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for(int i = 0; i< matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class SolutionTransposeMatrix867 {
    public int[][] transpose(int[][] matrix) {
        int transposed[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0; i< matrix[0].length;i++) {
            for(int j=0;j<matrix.length;j++) {
                transposed[i][j]=matrix[j][i];
            }
        }
        return transposed;
    }

    public int[][] transform_90_degree(int[][] matrix) {
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        int[][] result = new int[maxRows][maxCols];
        for(int row=0; row < maxRows; row++) {
            for(int col=0; col < maxCols; col++) {
                result[col][maxRows-row-1] = matrix[row][col];
            }
        }
        return result;
    }


}
