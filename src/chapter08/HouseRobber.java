package chapter08;

import java.util.Arrays;

/**
 * rob alternate houses for max money.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {6, 7, 1, 3, 8, 2, 4}; //{3, 6, 2, 1, 5, 1, 2, 9};
        int len = houses.length;
        int max = robHouses(houses, len);
        System.out.println("DP :: " + max);

        max = robHousesRecursive(houses, len);
        System.out.println("recursive :: " + max);

        int[] memo = new int[len + 1];
        Arrays.fill(memo, -1);
        max = robHousesRecursive(houses, len, memo);
        System.out.println("memo :: " + max);
        // printDP(len + 1, memo);

        max = robHousesIterative(houses, len);
        System.out.println("iterative ::  " + max);

        max = robCircularHousesIterative(houses, len);
        System.out.println("circular ::  " + max);

    }

    static int robHouses(int[] houses, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + houses[i], dp[i - 1]);
        }
        //printDP(n, dp);
        return dp[n - 1];
    }

    private static void printDP(int n, int[] dp) {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        printArray(n, dp);
    }

    private static void printArray(int n, int[] dp) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    static int robHousesRecursive(int[] houses, int n) {
        if (n <= 0) return 0;
        if (n == 1) return houses[0];

        return Math.max(houses[n - 1] + robHousesRecursive(houses, n - 2), robHousesRecursive(houses, n - 1));
    }

    static int robHousesRecursive(int[] houses, int n, int[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return houses[0];

        if (memo[n] != -1) return memo[n];

        memo[n] = Math.max(houses[n - 1] + robHousesRecursive(houses, n - 2, memo), robHousesRecursive(houses, n - 1, memo));

        return memo[n];
    }

    static int robHousesIterative(int[] houses, int n) {
        if (n == 0) return 0;
        if (n == 1) return houses[0];
        int secondLast = 0, last = 0;
        for (int i : houses) {
            int temp = Math.max(i + secondLast, last);
            secondLast = last;
            last = temp;
        }
        return last;
    }

    static int robCircularHousesIterative(int[] houses, int n) {

        int[] housesToPick1 = new int[n]; // houses from 1..n - skip 1st house
        int[] housesToPick2 = new int[n]; // houses from 0..n-1 - skip last house
        housesToPick1[0] = -1;

        for (int i = 1; i < n; i++) {
            housesToPick1[i] = houses[i];
        }
        int path1 = robHousesIterative(housesToPick1, n);
        printArray(n, housesToPick1);

        System.out.println("max of 1st subarray: " + path1);

        for (int i = 0; i < n - 1; i++) {
            housesToPick2[i] = houses[i];
        }


        housesToPick2[n - 1] = -1;
        printArray(n, housesToPick2);

        int path2 = robHousesIterative(housesToPick2, n);
        System.out.println("max of 2nd subarray: " + path2);

        return Math.max(path1, path2);
    }
}
