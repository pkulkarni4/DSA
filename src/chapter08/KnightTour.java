package chapter08;

import java.util.Arrays;

public class KnightTour {
    static int[] ROW = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] COL = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        int n = 8;
        int[][] path = knightTourUtil(n);
        printPath(path);
    }

    static void printPath(int[][] res) {
        for (int[] row : res) {
            //System.out.println("|");
            for (int val : row) {
                String space = val < 10 ? "  | ": " | ";
                System.out.print(" |\t" + val + space);
            }
            System.out.println(" ");
        }
    }

    static int[][] knightTourUtil(int n) {
        int[][] board = new int[n][n];
        for (int[] row : board) {
            Arrays.fill(row, -1);
        }

        board[0][0] = 0;
        int step = 1, x = 0, y = 0;

        if (knightTour(x, y, step, n, board)) {
            return board;
        }

        return new int[][]{{-1}};
    }

    static boolean knightTour(int x, int y, int step, int n, int[][] board) {
        if (step == n * n) {
            // backtrack before returning
            //board[x][y] = -1;
            return true;
        }

        // try all 8
        for (int i = 0; i < n; i++) {
            // calculate next steps
            int nx = x + ROW[i];
            int ny = y + COL[i];
            if (isBoardPositionValid(nx, ny, n, board)) {
                board[nx][ny] = step;
                if(knightTour(nx, ny, step + 1, n, board)){
                    return true;
                }
                // Backtrack
                board[nx][ny] = -1;
            }
        }
        return false;
    }

    static boolean isBoardPositionValid(int x, int y, int n, int[][] board) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
}
