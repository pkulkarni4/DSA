package graphs;

import java.util.*;

public class ShortestPathChessKnight {
    public static void main(String[] args) {
        ChessKnight ck = new ChessKnight();
        int numberOfMoves = ck.shortestPath(0, 7, 7, 0);
        System.out.println("num of moves : " + numberOfMoves);
    }
}

class ChessKnight {
    // board size
    int n;

    ChessKnight() {
        n = 8;
    }

    ChessKnight(int n) {
        this.n = n;
    }

    int shortestPath(int rs, int cs, int re, int ce) {
        ChessCell start = new ChessCell(rs, cs);
        ChessCell target = new ChessCell(re, ce);
        return shortestPathBFS(start, target);
    }

    int shortestPathBFS(ChessCell start, ChessCell target) {
        int[] ROW = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] COL = {-1, 1, 1, -1, 2, -2, 2, -2};
        Set<ChessCell> visited = new HashSet<>();
        Queue<ChessCell> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            ChessCell cell = queue.poll();
            // target cell found, return the distance
            if (cell.r == target.r && cell.c == target.c) {
                return cell.distance;
            }
            //
            if (!visited.contains(cell)) {
                visited.add(cell);
                for (int i = 0; i < 8; i++) {
                    int rt = cell.r + ROW[i];
                    int ct = cell.c + COL[i];
                    if (validCell(rt, ct)) {
                        queue.add(new ChessCell(rt, ct, cell.distance + 1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    boolean validCell(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}

class ChessCell {
    int r;
    int c;
    int distance;

    public ChessCell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public ChessCell(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}