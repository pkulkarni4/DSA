package chapter08;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int countWays = climbStairs(n, 0);
        System.out.println(countWays);

        countWays = climbStairs(n);
        System.out.println(countWays);
    }

    static int climbStairs(int n, int step) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return climbStairs(n-1, step+1) + climbStairs(n-2, step+1);
    }

    static int climbStairs(int n, int[] memo) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memo[n]!=0) return memo[n];
        memo[n] = climbStairs(n-1) + climbStairs(n-2);
        return memo[n+1];
    }

    static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
