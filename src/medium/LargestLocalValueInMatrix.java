package medium;

public class LargestLocalValueInMatrix {
    public static void main(String[] args) {
        int N = 4;
        int[][] mat = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        SolutionLargestLocalValueInMatrix m = new SolutionLargestLocalValueInMatrix();
        int[][] res = m.largestLocal(mat);
        Util.printArray(res);
    }

}

class SolutionLargestLocalValueInMatrix {
   private int findMax(int[][] mat, int start, int end){
        int max = 0;
        for(int i=start;i<start+3;i++){
            for(int j=end;j<end+3;j++){
                max = Math.max(max, mat[i][j]);
            }
        }
        return max;
    }

    int[][] largestLocal(int[][] grid){
       int N = grid.length;
       int[][] maxLocal = new int[N-2][N-2];
       for(int i=0;i<N-2;i++){
           for(int j=0;j<N-2;j++){
               maxLocal[i][j] = findMax(grid, i, j);
           }
       }
       return maxLocal;
    }


}
