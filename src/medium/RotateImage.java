package medium;

public class RotateImage {
    public static void main(String[] args) {
        int[][] img = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}
        };

        int row = img.length, col = img[0].length;
        System.out.println("row: " + row + " col: "+col);
       // int[][] rotatedImage = rotateImage(img);
        Util.printArray(img);
        TransposeMatrix tm = new TransposeMatrix();
        int[][] transposed = tm.transpose(img);
        row = transposed.length;
        col = transposed[0].length;
       // System.out.println("row: " + row + " col: "+col);
       // Util.printArray(transposed);

        tm.transposeInPlace(img);

    }
}

class TransposeMatrix{
    int[][] transpose(int[][] mat){
        int row = mat.length, col = mat[0].length;
        int[][] ret = new int[col][row];
        for(int r=0;r<row;r++) {
            for(int c=0;c<col;c++) {
                ret[c][r] = mat[r][c];
            }
        }
        return ret;
    }

    void transposeInPlace(int[][] mat){
        Util.printArray("input: ", mat);
        int row = mat.length, col = mat[0].length;
        //int[][] ret = new int[col][row];
        for(int r=0;r<row;r++) {
            for(int c=r;c<col;c++) {
                int temp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = temp;
            }
        }
        row = mat.length;
        col = mat[0].length;
     //   System.out.println("row: " + row + " col: "+col);
      //  Util.printArray("transposed: ", mat);

        // swap columns

        for(int r =0;r<row;r++){
            for(int c=0;c<col/2;c++) {
                int temp = mat[r][c];
                mat[r][c] = mat[r][col-1-c];
                mat[r][col-1-c] = temp;
            }
        }

        Util.printArray("rotated: ", mat);

    }
}