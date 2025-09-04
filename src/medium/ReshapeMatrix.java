package medium;

public class ReshapeMatrix {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int r = 3, c = 2;
        SolutionReshapeMatrix m = new SolutionReshapeMatrix();
        int[][] res = m.reshapeMatrixTo(grid, r, c);
        Util.printArray(res);

        res = m.reshapeMatrixColumn(grid, r, c);
        Util.printArray(res);

    }
}
class SolutionReshapeMatrix {

    int[][] reshapeMatrixTo(int[][] grid, int r, int c) {
        int [][] res = new int[r][c];
        int row = grid.length, col = grid[0].length;
        if(r*c != row*col)
            return grid;

        for(int i = 0;i < row*col; i++){
            System.out.println("row: "+ i/col+ "  col: "+ (i%col) +"  value: " +grid[i/col][i%col] +" copy to row: " + (i/row) +" copy to col: "+ (i%row));
            res[i/c][i%c] = grid[i/col][i%col];
        }
        return res;
    }

    int[][] reshapeMatrixColumn(int[][] grid, int r, int c) {
        int [][] res = new int[r][c];
        int row = grid.length, col = grid[0].length, out_rows =0, out_cols = 0;
        if(r*c != row*col)
            return grid;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++){
                res[out_rows][out_cols] = grid[i][j];
                out_cols++;

                if(out_cols == c){
                    out_cols = 0;
                    out_rows++;
                }
            }
        }
        return res;
    }
}