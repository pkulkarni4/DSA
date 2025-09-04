package chapter08;

public class ColorSpots {
    public static void main(String[] args) {

        int[][] a = {{1, 2, 3, 3, 2}, {2, 1, 2, 3, 3}, {2, 3, 3, 3, 3}, {3, 2, 1, 1, 3}, {1, 3, 2, 3, 3}};
        int rows = a.length, cols = a[0].length, k = 3;
        ColorGrid colorGrid = new ColorGrid();
        colorGrid.determineMaxColorSpots(a, rows, cols);
    }

}

class ColorGrid {
    int cc = 0;

    public void determineMaxColorSpots(int[][] a, int rows, int cols) {
        int maxSpots = -1;
        int color = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] != -1) {
                    cc = 0;
                    computeMaxColorSpot(i, j, rows, cols, a, a[i][j]);
                    if (cc > maxSpots) {
                        maxSpots = cc;
                        color = a[i][j] * -1;
                    }
                }
            }
        }
        System.out.println(" color : " + color + " has biggest spot of : " + maxSpots + " spaces.");

    }

    public void computeMaxColorSpot(int i, int j, int rows, int cols, int[][] a, int color) {
        a[i][j] = a[i][j] * -1;
        cc++;
        if (i > 1 && a[i - 1][j] == color) {
            computeMaxColorSpot(i - 1, j, rows, cols, a, color);
        }
        if ((i + 1) < rows && a[i + 1][j] == color) {
            computeMaxColorSpot(i + 1, j, rows, cols, a, color);
        }
        if (j > 1 && a[i][j - 1] == color) {
            computeMaxColorSpot(i, j - 1, rows, cols, a, color);
        }
        if ((j + 1) < cols && a[i][j + 1] == color) {
            computeMaxColorSpot(i, j + 1, rows, cols, a, color);
        }
    }
}