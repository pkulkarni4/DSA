package chapter08;

/*
LC#79 : Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 */
public class WordSearch {
    public static void main(String[] args) {
        String[][] board = {
                {"A", "B", "C", "E"},
                {"S", "F", "C", "S"},
                {"A", "D", "E", "E"}
        };
        String word = "ABCE";
        int rows = board.length, cols = board[0].length;
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[rows][cols];
        boolean wordExists = doesWordExists(rows, cols, board, word);;//doesWordExistInGrid(board, word, rows, cols, 0, 0, sb, 0, visited);
        System.out.println("word : " + word + " exists: " + wordExists);

        String[][] board1 = {
                {"A", "B", "C", "E"},
                {"S", "F", "C", "S"},
                {"A", "D", "E", "E"}
        };
        word = "ASADEESE";

        boolean wordExists1 = doesWordExists(rows, cols, board1, word);
        System.out.println("word : " + word + " exists: " + wordExists1);

        word = "ABCB";

        visited = new boolean[rows][cols];
        wordExists = doesWordExists(rows, cols, board1, word);//doesWordExistInGrid(board, word, rows, cols, 0, 0, sb, 0, visited);
        System.out.println("word : " + word + " exists: " + wordExists);
    }

    private static boolean doesWordExists(int rows, int cols, String[][] board1, String word) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (doesWordExistInGrid(board1, word, rows, cols, i, j, sb, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean doesWordExistInGrid(String[][] board, String word, int rows, int cols, int i, int j, StringBuilder sb, int index, boolean[][] visited) {

        if (sb.toString().equals(word)) {
            //System.out.println(sb.toString());
            return true;
        }

        char ch = word.charAt(index);
        String chStr = String.valueOf(ch);
        if (i >= rows || i < 0 || j >= cols || j < 0 || !board[i][j].equals(chStr))
            return false;

        if (sb.length() < word.length() && board[i][j].equals(chStr) && !visited[i][j]) {
            sb.append(board[i][j]);
            visited[i][j] = true;
            if (doesWordExistInGrid(board, word, rows, cols, i, j + 1, sb, index + 1, visited) ||
                    doesWordExistInGrid(board, word, rows, cols, i + 1, j, sb, index + 1, visited) ||
                    doesWordExistInGrid(board, word, rows, cols, i - 1, j, sb, index + 1, visited) ||
                    doesWordExistInGrid(board, word, rows, cols, i, j - 1, sb, index + 1, visited)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            visited[i][j]= false;
        }
        return false;
    }
}
