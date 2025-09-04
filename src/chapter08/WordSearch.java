package chapter08;

public class WordSearch {
    public static void main(String[] args) {
        String[][] board = {
                {"A", "B", "C", "E"},
                {"S", "F", "C", "S"},
                {"A", "D", "E", "E"}
        };
        String word = "ABCESE";
        int rows = board.length, cols = board[0].length;
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[rows][cols];
        boolean wordExists = doesWordExistInGrid(board, word, rows, cols, 0, 0, sb, 0, visited);
        System.out.println(wordExists);
    }

    static boolean doesWordExistInGrid(String[][] board, String word, int rows, int cols, int i, int j, StringBuilder sb, int index, boolean[][] visited) {

       // System.out.println(" --> " + sb + " equality: " + sb.toString().equals(word));
        if (sb.toString().equals(word)) {
            return true;
        }

        if (sb.length() < word.length() && i < rows && j < cols && i >= 0 && j >= 0 && board[i][j].equals("" + word.charAt(index)) && !visited[i][j]) {

           // System.out.println("board[" + i + "][" + j + "]: " + board[i][j] + " word charAt (" + index + ") : " + word.charAt(index) + " equal : " + board[i][j].equals("" + word.charAt(index)) + " sb : " + sb.toString());

            //if (board[i][j].equals("" + word.charAt(index))) {
                sb.append(board[i][j]);
                visited[i][j] = true;
               // System.out.println("appending : " + board[i][j] +  " formed word: " + sb);
                return doesWordExistInGrid(board, word, rows, cols, i, j + 1, sb, index + 1, visited) ||
                doesWordExistInGrid(board, word, rows, cols, i + 1, j, sb, index + 1, visited) ||
                doesWordExistInGrid(board, word, rows, cols, i - 1, j, sb, index + 1, visited) ||
                doesWordExistInGrid(board, word, rows, cols, i, j - 1, sb, index + 1, visited);
           // }
        }
        //visited[i][j] = false;
        return false;
    }
}
