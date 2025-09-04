package chapter08;

import java.util.Random;

public class TheFallingBall {
    public static void main(String[] args) {
        TheFallingBallSolution s = new TheFallingBallSolution();
        int cols = 5;
        int rows = 5;
        int elevation = 5; // a cell can have the elevation 1, 2, 3, 4 or 5 (the highest)

        Random rnd = new Random();

        int[][] elevations = {
                {5, 2, 1, 1, 1},
                {3, 5, 2, 2, 3},
                {2, 3, 5, 3, 1},
                {2, 4, 3, 3, 3},
                {1, 3, 1, 2, 3}
        };

        // add random elevations
        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elevations[i][j] = 1 + rnd.nextInt(elevation);
            }
        }*/
        // show the grid on screen
        System.out.println("Initial grid:");
        printGrid(rows, cols, elevations);
/*
        s.computePath(elevations[rows / 2][cols / 2],
                rows / 2, cols / 2, rows, cols, elevations);

        s.computePath(elevations[rows-1][cols-1],
                0, 0, rows, cols, elevations);
*/
        s.computePath(0, cols-1, rows, cols, elevations, elevations[0][cols-1]);

        // show the grid on screen
        System.out.println("final grid:");
        printGrid(rows, cols, elevations);
    }

    static void printGrid(int rows, int cols, int[][] elevations) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.format("%2s", elevations[i][j]);
            }
            System.out.println();
        }
    }
}

class TheFallingBallSolution {
    public void computePath(int prevElevation, int i, int j,
                            int rows, int cols, int[][] elevations) {
        // we ensure the ball is still on the grid
        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {

            int currentElevation = elevations[i][j];
            // we check if the ball can fall from the previous cell to this cell
            if (prevElevation >= currentElevation && currentElevation > 0) {

                // we store the current elevation because we needed it for the next move
                prevElevation = currentElevation;

                // we mark this cell as visited
                elevations[i][j] = 0;

                // try to move the ball
                computePath(prevElevation, i, j - 1, rows, cols, elevations);
                computePath(prevElevation, i - 1, j, rows, cols, elevations);
                computePath(prevElevation, i, j + 1, rows, cols, elevations);
                computePath(prevElevation, i + 1, j, rows, cols, elevations);
            }
        }
    }

    public void computePath(int i, int j, int rows, int cols, int[][] elevations, int previousElevation) {
        if (i >= 0 && i <= (rows - 1) && j >= 0 && j <= (cols - 1)) {
            int currentElevation = elevations[i][j];
            if (previousElevation >= currentElevation && currentElevation > 0) {
                previousElevation = currentElevation;
                elevations[i][j] = 0;
                // move the ball in all dir
                computePath(i, j - 1, rows, cols, elevations, previousElevation);
                computePath(i, j + 1, rows, cols, elevations, previousElevation);
                computePath(i - 1, j, rows, cols, elevations, previousElevation);
                computePath(i + 1, j, rows, cols, elevations, previousElevation);
            }

        }
    }

    boolean withinGridRange(int[][] elevations, int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}