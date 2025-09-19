package arrays.dfs;

import medium.Util;

import java.util.ArrayList;
import java.util.List;

/*
LC 417 - pacific and atlantic water flow.
 */
public class PacificAtlanticWaterFlow417 {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        // Util.printArray("input", heights);
        Solution417 s = new Solution417();
        List<List<Integer>> res = s.pacificAtlantic(heights);
        printList(res);
    }

    static void printList(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

/*
solution is to use two boolean matrices of same size as input. one will mark water flows to atlantic and another to pacific.
Finding common cells will get us the cells thru which water flows to both.
dfs and check 4 neighboring cells if height of the current cell is lesser (that means water can flow)

 */
class Solution417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null) return null;

        int rows = heights.length, cols = heights[0].length;
        boolean[][] waterFlowToAtlantic = new boolean[rows][cols];
        boolean[][] waterFlowToPacific = new boolean[rows][cols];

        // call dfs
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dfs(heights, i, j, waterFlowToPacific, rows, cols);
                }
                if (i == rows - 1 || j == cols - 1) {
                    dfs(heights, i, j, waterFlowToAtlantic, rows, cols);
                }
            }
        }
//        printAtlantic("Atlantic", waterFlowToAtlantic);
//        printAtlantic("Pacific", waterFlowToPacific);

        // merge
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (waterFlowToAtlantic[i][j] && waterFlowToPacific[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }

    private static void printAtlantic(String Atlantic, boolean[][] waterFlowToAtlantic) {
        System.out.println(Atlantic);
        Util.printArray(waterFlowToAtlantic);
    }

    void dfs(int[][] heights, int row, int col, boolean[][] visited, int rows, int cols) {
        if (row < 0 || col >= cols || row >= rows || cols < 0 || visited[row][col]) return;

        visited[row][col] = true;

        int height = heights[row][col];
        if (row < rows - 1 && heights[row + 1][col] >= height) {
            dfs(heights, row + 1, col, visited, rows, cols);
        }
        if (row > 0 && heights[row - 1][col] >= height) {
            dfs(heights, row - 1, col, visited, rows, cols);
        }
        if (col < cols - 1 && heights[row][col + 1] >= height) {
            dfs(heights, row, col + 1, visited, rows, cols);
        }
        if (col > 0 && heights[row][col - 1] >= height) {
            dfs(heights, row, col - 1, visited, rows, cols);
        }
    }
}
