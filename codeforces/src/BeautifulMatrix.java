public class BeautifulMatrix {
    public static void main(String[] args) {
        //int[][] mat = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] mat = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        BeautifulMatrixSolution ss = new BeautifulMatrixSolution();
        int moves = ss.beautify(mat);
        System.out.println(moves);
    }
}

class BeautifulMatrixSolution {
    int beautify(int[][] matrix) {
        int ret = 0, i = 0, j = 0, x = 0, y = 0;

        // 1. find where 1 is located store in i,j
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (matrix[i][j] == 1) {
                    // 2. abs(i-2) + abs(j-2)
                    return Math.abs(i - 2) + Math.abs(j - 2);
                }
            }
        }
        return ret;
    }
}