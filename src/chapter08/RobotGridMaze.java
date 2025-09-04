package chapter08;

import java.util.HashSet;
import java.util.Set;

public class RobotGridMaze {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[6][6];
        Point[] forbiddenSpots = {new Point(2, 0), new Point(3, 0), new Point(3, 1), new Point(3, 2), new Point(3, 3)};
        int rows = maze.length;
        int cols = maze[0].length;
        setUp(maze, rows, cols, forbiddenSpots, forbiddenSpots.length);

        // print maze
        printMaze(maze, rows, cols);

        Set<Point> path = new HashSet<>();
        long start = System.currentTimeMillis();
        boolean hasPath = explorePath(maze, rows - 1, cols - 1, path);
        long end = System.currentTimeMillis();

        System.out.println("time take: " + (end - start) + " ms");
        if (hasPath) {
            System.out.println("has path : ");
            for (Point p : path) {
                System.out.print("( " + p.getX() + ", " + p.getY() + " ) --> ");
            }
        } else {
            System.out.println("no path");
        }

        /// / min path

        int steps = 0;
        int minSteps = exploreMinPath(maze, rows - 1, cols - 1, steps);
        System.out.println(" min steps ---> " + minSteps);

        int paths = countPathsBottomUp(4,4);
        System.out.println("paths: " + paths);
    }

    static int exploreMinPath(boolean[][] maze, int rows, int cols, int steps) {
        if (rows < 0 || cols < 0) return steps;
        if (!maze[rows][cols]) return steps;
        if (rows == 0 && cols == 0) return steps; // reached end


        return Math.min(exploreMinPath(maze, rows - 1, cols, steps + 1),
                exploreMinPath(maze, rows, cols - 1, steps + 1));

    }

    // Memoization
    public static int countPathsBottomUp(int m, int n) {

        if (m <= 1 || n <= 1) {
            return -1;
        }

        // cache the results of subproblems
        int[][] count = new int[m][n];

        // go in any cell of the first row is 1
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        // go in any cell of the first column is 1
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        // determine the paths for other cells in bottom-up manner
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
                // if diagonal movements are allowed then add: + count[i-1][j-1];
            }
        }

        return count[m - 1][n - 1];
    }

    static boolean explorePath(boolean[][] maze, int rows, int cols, Set<Point> path) {
        if (rows < 0 || cols < 0) return false;
        if (!maze[rows][cols]) return false;
        if ((rows == 0 && cols == 0) ||
                explorePath(maze, rows - 1, cols, path) ||
                explorePath(maze, rows, cols - 1, path)) {
            path.add(new Point(rows, cols));
            return true;
        }
        return false;
    }

    static void printMaze(boolean[][] maze, int m, int n) {
        for (int i = 0; i < m; i++) {
            System.out.print(" | ");
            for (int j = 0; j < n; j++) {
                String val = maze[i][j] ? "T" : "F";
                System.out.print(val + " | ");
            }
            System.out.println();
        }
    }

    static void setUp(boolean[][] maze, int m, int n, Point[] forbiddenSpots, int x) {
        // fill maze with true
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = true;
            }
        }
        // set up forbidden spaces
        for (int i = 0; i < x; i++) {
            Point fp = forbiddenSpots[i];
            maze[fp.getX()][fp.getY()] = false;
        }

    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}