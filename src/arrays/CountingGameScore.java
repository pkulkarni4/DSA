package arrays;

/*
Consider a game where a player can score 3, 5, or 10 points in a single move. Moreover, consider that you've been given a total score, n.

Write a snippet of code that returns the number of ways to reach this score.
 */
public class CountingGameScore {
    public static void main(String[] args) {
        int[] points = {3, 5, 10};
        int n = 33;
        System.out.println("recursive: " + noOfWays(n, 0, points));
        int[][] memo = new int[n + 1][points.length];
        System.out.println("memoization: " + noOfWays(33, 0, points, memo));

        System.out.println("DP: " + noOfWays(n));
    }

    static int noOfWays(int n, int i, int[] points) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (i == 3) return 0; // reached last point

        return noOfWays(n - points[i], i, points) + noOfWays(n, i + 1, points);
    }

    /*
    There are two parameters: n and i that changes in the recursive solution. So we create a 2D matrix of size (n+1)*3 for memoization.
     */
    static int noOfWays(int n, int i, int[] points, int[][] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (i == 3) return 0; // reached last point

        if (memo[n][i] != 0) {
            return memo[n][i];
        }
        memo[n][i] = noOfWays(n - points[i], i, points, memo) + noOfWays(n, i + 1, points, memo);
        return memo[n][i];
    }

    /*
    The idea is to fill the DP table based on previous values. For each point, we either include it or exclude it to compute the number of ways needed for each score.
    The table is filled in an iterative manner from score i = 1 to i = n and for each point points[j] from j=2 to j=0.

    The dynamic programming relation is as follows:

        if (i-points[j]) is greater than 0, then dp[i][j] = dp[i-points[j]][j] + dp[i][j+1]
        else dp[i][j] = dp[i][j+1].
     */
    static int noOfWays(int n) {
        int[] points = {3, 5, 10};
        int[][] dp = new int[n + 1][points.length + 1];

        //set 1 for score 0 for all points
        for (int i = 0; i < points.length + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j >= 0; j--) {
                if (i - points[j] >= 0) {
                    dp[i][j] = dp[i - points[j]][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }
        return dp[n][0];
    }
}
