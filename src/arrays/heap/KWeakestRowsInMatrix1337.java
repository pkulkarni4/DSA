package arrays.heap;

import java.util.PriorityQueue;

/*
given m x n binary matrix, 1 are soldiers and 0 are civilians. 1s are placed to left of 0

a row i is weaker than j, if:
# number of soldiers in row i is < row j
# both have same number of soldiers but i < j

Return k weakest rows.

example: matrix = {
{1,1,0,0,0},
{1,1,1,1,0},
{1,0,0,0,0},
{1,1,0,0,0},
{1,1,1,1,1}
}
output: [2, 0, 3]
*/
public class KWeakestRowsInMatrix1337 {
    public static void main(String[] args) {
        KWeakestRowsInMatrix1337Solution s = new KWeakestRowsInMatrix1337Solution();
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int[] weakest = s.kWeakestRows(matrix, 3);
        for (int i : weakest)
            System.out.print(i + " ");

        System.out.println("----");
        int[][] mat = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        int k = 2;
        weakest = s.kWeakestRows(mat, k);
        for (int i : weakest)
            System.out.print(i + " ");
    }
}

class KWeakestRowsInMatrix1337Solution {

    /*
    find count of soldiers in each row along with row index
    {0, 2}, {1, 4}, {2, 1}, {3, 2}, {4, 5}

     */
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<WeakRow> pq = new PriorityQueue<>((wr1, wr2) -> {
            if (wr1.soldierCount == wr2.soldierCount) {
                return wr1.row - wr2.row;
            }
            return wr1.soldierCount - wr2.soldierCount;
        });
        int rowCount = 0;
        for (int[] row : mat) {
            int count = countSoldiers(row);
           // System.out.println(" row : " + rowCount + " has soldiers => " + count);
            pq.add(new WeakRow(rowCount, count));
            rowCount++;
        }
        int[] res = new int[k];
        int idx = 0;
        while (k > 0) {
            res[idx++] = pq.poll().row;
            k--;
        }
        return res;
    }

    private int countSoldiers(int[] row) {
        int count = 0;
        for (int i : row) {
            if (i == 1) count++;
        }
        return count;
    }
}

class WeakRow {
    int row;
    int soldierCount;

    public WeakRow(int row, int soldierCount) {
        this.row = row;
        this.soldierCount = soldierCount;
    }
}
