package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
LC#994 - Rotting oranges.

 */
public class RottingOranges {
    public static void main(String[] args) {
        int[][] example1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int[][] example2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int[][] example4 = {
                {1, 1, 1},
                {1, 2, 1},
                {1, 1, 1}
        };

        int[][] example3 = {{0, 2}};

        RottingOrangesSolution ros = new RottingOrangesSolution();
        int s1 = ros.orangesRotting(example1);
        System.out.println(s1);
        int s2 = ros.orangesRotting(example2);
        System.out.println(s2);
        int s3 = ros.orangesRotting(example3);
        System.out.println(s3);
        int s4 = ros.orangesRotting(example4);
        System.out.println(s4);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class RottingOrangesSolution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> queue = new ArrayDeque<>();
        int mins = 0;
        // orangesRotting(grid, rows, cols, visited, 0, 0, mins);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    // rotten, add to queue
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        // send prepared queue and visited
        return orangesRotting(grid, rows, cols, queue, visited);
    }

    int orangesRotting(int[][] grid, int rows, int cols, Queue<Point> queue, boolean[][] visited) {
        int minutes = 0;
        while (!queue.isEmpty()) {
            List<Point> rotten = new ArrayList<>();
            while (!queue.isEmpty()) {
                rotten.add(queue.poll());
            }
            for (Point p : rotten) {
                // get 4 points that are not visited and are 1
                List<Point> neighbors = getValidNeighbors(grid, p, rows, cols, visited);
                queue.addAll(neighbors);
            }
            if (queue.isEmpty()) {
                //System.out.println("qeue is empty");
                break;
            }
            minutes++;
        }
        // find if there are still unvisited cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                //    System.out.println("found unvisited 1 at pos: " + i + " , " + j);
                    return -1;
                }
            }
        }

        return minutes;
    }

    List<Point> getValidNeighbors(int[][] grid, Point p, int rows, int cols, boolean[][] visited) {
        int i = p.x, j = p.y;
        List<Point> neighbors = new ArrayList<>();

        if (j < cols - 1 && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            grid[i][j + 1] = 2;
            neighbors.add(new Point(i, j + 1));
        }

        if (j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            grid[i][j - 1] = 2;
            neighbors.add(new Point(i, j - 1));
        }

        if (i < rows - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            grid[i + 1][j] = 2;
            neighbors.add(new Point(i + 1, j));
        }

        if (i > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            grid[i - 1][j] = 2;
            neighbors.add(new Point(i - 1, j));
        }

        return neighbors;
    }
}
