package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC#51 - N-Queens puzzle

 */
public class NQueens {
    public static void main(String[] args) {
        NQueens51Solution sol = new NQueens51Solution();
        List<List<String>> res = sol.solveNQueens(4);
        System.out.println("number of solutions: " + res.size());
        for (List<String> ans : res) {
            for (String i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class NQueens51Solution {
    /*

g: A 2D list representing the chessboard, initialized with all '.' (empty squares)
col: An array of size n to track which columns have queens (col[j] = 1 if column j has a queen)
dg: An array of size 2n for diagonal tracking (using index i + j)
udg: An array of size 2n for anti-diagonal tracking (using index n - i + j)
ans: List to store all valid board configurations

for current row i, try placing a queen in each column j from 0..n-1
to check if g[i][j] is safe to place a queen, use - col[j] + dg[i+j] + udg[n-i+j] == 0 (1 depicts queen has been placed)

*/
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        List<List<String>> result = new ArrayList<>();
        for (String[] rows : board) {
            Arrays.fill(rows, ".");
        }
        int[] col = new int[n];
        int[] dg = new int[n * 2];
        int[] udg = new int[n * 2];

        solveNQueens(board, n, 0, result, col, dg, udg);

        return result;
    }

    void solveNQueens(String[][] board, int n, int currentRow, List<List<String>> result, int[] col, int[] dg, int[] udg) {
        if (n == currentRow) {
            // all queens placed
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(String.join("", board[i]));
            }
            result.add(ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] + dg[currentRow + i] + udg[n - currentRow + i] == 0) {
                board[currentRow][i] = "Q";
                col[i] = 1;
                dg[currentRow + i] = 1;
                udg[n - currentRow + i] = 1;
                solveNQueens(board, n, currentRow + 1, result, col, dg, udg);
                // backtrack
                col[i] = 0;
                dg[currentRow + i] = 0;
                udg[n - currentRow + i] = 0;
                board[currentRow][i] = ".";
            }
        }
    }
}