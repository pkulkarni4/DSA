package graphs;

/*
LC # 935: We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell

1 | 2 | 3
__  __ __
4 | 5 | 6
__  __ __
7 | 8 | 9
__  __ __
* | 0 | #

Find
 */
public class KnightDialer935 {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3131};
        KnightDialer935Solution s = new KnightDialer935Solution();
        for (int i : input) {
            int n = s.knightDialer(i);
            System.out.println(n);
        }

        KnightDialer935SolutionInDP dp = new KnightDialer935SolutionInDP();
        for (int i : input) {
            int sol = dp.knightDialer(i);
            System.out.println(sol);
        }
    }
}

class KnightDialer935SolutionInDP {
    int max = (int) Math.pow(10, 9) + 7;
    int n;
    int[][] memo;
    int[][] jumps = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4}
    };

    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n + 1][10];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp(n - 1, i)) % max;
        }
        return ans;
    }

    int dp(int remaining, int square) {
        if (remaining == 0) return 1;
        if (memo[remaining][square] != 0) return memo[remaining][square];

        int ans = 0;
        for (int nextSq : jumps[square]) {
            ans = (ans + dp(remaining - 1, nextSq)) % max;
        }
        memo[remaining][square] = ans;
        return ans;
    }
}

class KnightDialer935Solution {
    int max = (int) Math.pow(10, 9) + 7;

    public int knightDialer(int n) {
        long[][][] memo = new long[n + 1][4][3];
        long s = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                s = (s + paths(i, j, n, memo)) % max;
            }
        }
        return (int) s;
    }

    long paths(int r, int c, int n, long[][][] memo) {
        if (r < 0 || c < 0 || r >= 4 || c >= 3 || (r == 3 && c != 1)) return 0;
        if (n == 1) return 1;

        if (memo[n][r][c] > 0) return memo[n][r][c];

        memo[n][r][c] = paths(r - 1, c - 2, n - 1, memo) % max +
                paths(r - 2, c - 1, n - 1, memo) % max +
                paths(r - 2, c + 1, n - 1, memo) % max +
                paths(r - 1, c + 2, n - 1, memo) % max +
                paths(r + 1, c + 2, n - 1, memo) % max +
                paths(r + 2, c + 1, n - 1, memo) % max +
                paths(r + 2, r - 1, n - 1, memo) % max +
                paths(r + 1, c - 2, n - 1, memo) % max;

        return memo[n][r][c];
    }
}
