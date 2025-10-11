package backtracking;

/*
LC#36 : Valid Sudoku
Determine if 9 x 9 sudoku board is valid. only the filled cells need to be validated according to:
# each row must contain the digits 1-9 without repeating
# each column must contain the digits 1-9 without repeating
# each of the nine 3 x 3 sub boxes must contain the digits 1-9 without repeating
 */
public class ValidSudoku {
    public static void main(String[] args) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        char[][] b1 = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                b1[i][j] = board[i][j].charAt(0);
            }
        }
        ValidSudoku36Solution sol = new ValidSudoku36Solution();
        System.out.println("" + sol.isValidSudoku(b1));
        b1[0][0] = '8';
        System.out.println("" + sol.isValidSudoku(b1));
    }
}

class ValidSudoku36Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr == '.') continue;

                int index = curr - '0' - 1;
                int subBox = (i / 3) * 3 + (j / 3);

                if (row[i][index] || col[j][index] || sub[subBox][index]) {
                    return false;
                }

                row[i][index] = true;
                col[j][index] = true;
                sub[subBox][index] = true;
            }
        }
        return true;
    }
}