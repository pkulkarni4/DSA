package g4g.dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {5, 2, 1, 4};
        int n = 4;

        int[][] memo = new int[coins.length][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        CoinChangeSolution s = new CoinChangeSolution();
        int changes = s.coinChange(coins, coins.length, n, memo);
        System.out.println("no of ways to change : " + n + " is : " + changes);

        changes = s.coinChange(coins, coins.length, n);
        System.out.println("no of ways to change : " + n + " is : " + changes);

        changes = s.minCoinChangeDP(coins, n);
        System.out.println("MIN  no of coins to change : " + n + " is : " + changes);

        int cc = s.coinChangeDP(coins, n);
        System.out.println("DP: no of ways to change : " + n + " is : " + cc);
    }
}

class CoinChangeSolution {
    int coinChange(int[] coins, int n, int sum) {
        if (sum == 0) return 1;
        if (sum < 0 || n <= 0) return 0;
        return coinChange(coins, n, sum - coins[n - 1]) + coinChange(coins, n - 1, sum);
    }

    int coinChange(int[] coins, int n, int sum, int[][] memo) {
        if (sum == 0) return 1;
        if (sum < 0 || n <= 0) return 0;
        if (memo[n - 1][sum] != -1) return memo[n - 1][sum];

        memo[n - 1][sum] = coinChange(coins, n, sum - coins[n - 1], memo) + coinChange(coins, n - 1, sum, memo);

        return memo[n - 1][sum];
    }

    int coinChangeDP(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] += dp[i - 1][j];
                if ((j - coins[i - 1]) >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    int minCoinChangeDP(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int leftover = i - coin;
                    // check if leftover is already calculated and stored in dp array
                    int coinsNeeded = dp[leftover];
                    int coinAlreadyGot = dp[i];
                    dp[i] = Math.min(coinAlreadyGot, coinsNeeded + 1);
                }
            }
        }
        for(int i: dp) {
            System.out.print( i +" ");
        }
        if (dp[target] == target + 1) return -1; // no solution found!
        return dp[target];
    }
}