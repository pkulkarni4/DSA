package stacksqueues.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Examples:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '1', '0' }
        };

        char[][] grid1 = {
                {'0', '0', '0', '0', '1' },
                {'0', '0', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };

        char[][] grid2
                = {
                {'1', '1', '1', '0', '0', '0', '1', '1', '0', '1' },
                {'0', '1', '1', '0', '1', '0', '1', '0', '0', '0' },
                {'1', '1', '1', '1', '0', '0', '1', '0', '1', '0' },
                {'1', '0', '0', '1', '0', '1', '0', '0', '0', '0' },
                {'1', '1', '1', '1', '1', '1', '0', '0', '0', '1' },
                {'0', '0', '0', '1', '0', '0', '1', '1', '0', '1' },
                {'0', '0', '0', '0', '0', '1', '1', '0', '0', '0' },
                {'1', '1', '0', '1', '0', '0', '0', '1', '1', '0' },
                {'1', '0', '0', '0', '1', '1', '0', '1', '0', '0' },
                {'1', '1', '0', '1', '0', '1', '0', '1', '1', '1' }
        };
        Solution200 s = new Solution200();
        int c1 = s.numIslands(grid);
        System.out.println(c1);

        int c3 = s.numIslands(grid1);
        System.out.println(c3);

        int c2 = s.numIslands(grid2);
        System.out.println(c2);

        System.out.println("---- recursive ------ ");

        CountIslandsSolution cSol = new CountIslandsSolution();

        int cs1 = cSol.numIslands(grid);
        System.out.println(cs1);

        int cs3 = s.numIslands(grid1);
        System.out.println(cs3);

        int cs2 = s.numIslands(grid2);
        System.out.println(cs2);
    }
}

class Solution200 {
    private static final int POSSIBLE_MOVEMENTS = 4;
    private static final int[] ROW = {1, -1, 0, 0};
    private static final int[] COL = {0, 0, 1, -1};

    /*
    use queue and bfs technique
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] - 48 == 1 && !visited[i][j]) {
                    visit(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void visit(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int r = queue.peek().r;
            int c = queue.peek().c;
            queue.poll();
            for (int k = 0; k < POSSIBLE_MOVEMENTS; k++) {
                int newRow = r + ROW[k];
                int newCol = c + COL[k];
                if (isValidCell(grid, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol));
                }
            }
        }
    }

    boolean isValidCell(char[][] grid, int r, int c, boolean[][] visited) {
        return
                r >= 0 && r < visited.length
                        && c >= 0 && c < visited[0].length
                        && grid[r][c] - 48 == 1
                        && !visited[r][c]
                ;
    }
}

class Cell {
    int r, c;

    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class CountIslandsSolution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '$';

        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
        dfs(grid, i, j + 1, m, n);
    }
}