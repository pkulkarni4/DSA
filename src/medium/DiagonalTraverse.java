package medium;

public class DiagonalTraverse {
    public static void main(String[] args) {
        SolutionDiagonalTraverse m = new SolutionDiagonalTraverse();
        int[][] mat = { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        m.findDiagonalOrder(mat);
    }
}

class SolutionDiagonalTraverse {
    public void findDiagonalOrder(int[][] mat) {

        int row = mat.length, col = mat[0].length;
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(mat[i+1][j-1]);
            }
        }
    }
}