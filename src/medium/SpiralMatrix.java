package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
//        int[][] mat = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        Util.printArray(mat);
        List<Integer> res = spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Util.printAList(res);
        res = spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        Util.printAList(res);

  //      res = spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
       // Util.printAList(res);

        int[][] matrx = generateMat(3);
        Util.printArray(matrx);
    }

    static List<Integer> spiralOrder(int[][] mat) {

        Util.printArray(mat);
        int columnBegin = 0, columnEnd = mat[0].length-1, rowBegin = 0, rowEnd=mat.length-1, count = 1;
        List<Integer> res = new ArrayList<>();
        while (columnBegin<=columnEnd && rowBegin<=rowEnd){
            for(int i=columnBegin;i<=columnEnd;i++){
                res.add(mat[rowBegin][i]);
            }
            rowBegin = rowBegin + 1;

            for(int i=rowBegin;i<=rowEnd;i++){
                res.add(mat[i][columnEnd]);
            }
            columnEnd = columnEnd - 1;

            if(rowBegin <= rowEnd){
                for(int i=columnEnd;i>=columnBegin;i--){
                    res.add(mat[rowEnd][i]);
                }
            }
            rowEnd = rowEnd - 1;

            if(columnBegin<=columnEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    res.add(mat[i][columnBegin]);
                }
                columnBegin=columnBegin+1;
            }

        }

        return res;
    }

    static int[][] generateMat(int n) {
        int [][] mat = new int[n][n];
        int columnBegin = 0, columnEnd = n-1, rowBegin = 0, rowEnd=n-1, count = 1;

        while (columnBegin<=columnEnd && rowBegin<=rowEnd){
            for(int i=columnBegin;i<=columnEnd;i++){
                mat[rowBegin][i] = count++;
            }
            rowBegin = rowBegin + 1;

            for(int i=rowBegin;i<=rowEnd;i++){
                mat[i][columnEnd] = count++;
            }
            columnEnd = columnEnd - 1;

            if(rowBegin <= rowEnd){
                for(int i=columnEnd;i>=columnBegin;i--){
                    mat[rowEnd][i] = count++;
                }
            }
            rowEnd = rowEnd - 1;

            if(columnBegin<=columnEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    mat[i][columnBegin] = count++;
                }
                columnBegin=columnBegin+1;
            }

        }
        return mat;
    }


}
