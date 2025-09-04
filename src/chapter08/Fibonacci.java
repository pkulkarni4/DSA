package chapter08;

public class Fibonacci {
    public static void main(String[] args) {
        int k = 5;
        int fib = fibonacciRecursive(k, new int[k + 1]);
        System.out.println("memo :: " + fib);

        fib = fibonacciIterative(k);
        System.out.println("iterative :: " + fib);

        fib = fibonacciDynamicProgramming(k);
        System.out.println("DP :: " + fib);
    }

    static int fibonacciRecursive(int k, int[] cache) {
        // base case
        if (k <= 1) {
            return k;
        }
        if (cache[k] > 0) return cache[k];

        cache[k] = fibonacciRecursive(k - 2, cache) + fibonacciRecursive(k - 1, cache);
        return cache[k];
    }

    static int fibonacciDynamicProgramming(int k) {
        if (k <= 1) return k;
        int[] dp = new int[k + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[k];
    }

    static int fibonacciIterative(int k) {
        if (k == 0) return 0;
        if (k == 1) return 1;

        int first = 1, second = 0;
        for (int i = 1; i < k; i++) {
            int temp = first + second;
            second = first;
            first = temp;
        }

        return first;
    }

}
