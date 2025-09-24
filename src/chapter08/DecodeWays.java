package chapter08;

/*
LC # 91: Decode ways
If 1-> "A", 2 -> "B", ... 26 -> "Z"
There can be number of ways to decode a given digits - "11106" -> "1, 1, 10, 6" or "11, 10, 6" but "11, 1, 06" is invalid
Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.
For ex:
s = "12", output = 2 as 12 can be decoded as 1, 2 or 12
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWaysSolution s = new DecodeWaysSolution();
        String[] input = {"12", "06", "226"};
        for (int i = 0; i < input.length; i++) {
            int n = s.getNumberOfWaysDP(input[i]);
            System.out.println(n);
        }
    }
}

class DecodeWaysSolution {

    public int getNumberOfWaysDP(String num) {
        if(num.startsWith("0")) return 0; // cannot have any ways
        int len = num.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < len + 1;i++) {
            // consider only one num, if it is between 1 and 9
            if(isBetween(num.substring(i-1, i),  1, 9)){
                dp[i] += dp[i-1];
            }
            // consider two nums, if it is between 10 and 26, this is the case when 0 is in the string and has to be considered with prev num
            if(isBetween(num.substring(i-2, i), 10, 26)){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

    boolean isBetween(String c, int min, int max) {
        int n = Integer.valueOf(c);
        return n >= min && n <= max;
    }

    // without memoization
    public int getNumberOfWays(String num) {
        return getNumberOfWays(num, 0);
    }

    private int getNumberOfWays(String num, int index) {
        int len = num.length();
        // if num starts with zero, return 0
        if (len == index) { // got proper decoded way
            return 1;
        }
        if (num.charAt(index) == '0') {
            return 0;
        }
        int res = getNumberOfWays(num, index + 1);
        if (index < len - 1 && (num.charAt(index) == '1' || num.charAt(index) == '2' && num.charAt(index + 1) < '7')) {// valid condition:
            // call recursively to use first 1 char or 2 chars
            // memoization needed
            res += getNumberOfWays(num, index + 2);
        }
        return res;
    }

    public int getNumberOfWays(String num, boolean usememo) {
        if (usememo) {
            int len = num.length();
            int[] memo = new int[len];
            getNumberOfWays(num, 0, memo);
        }

        return getNumberOfWays(num, 0);
    }

    private int getNumberOfWays(String num, int index, int[] memo) {
        int len = num.length();
        if (len == index) return 1;
        if (num.charAt(index) == '0') return 0;
        if (memo[index] != 0) return memo[index];
        int res = getNumberOfWays(num, index + 1, memo);
        if (index < len - 1 && (num.charAt(index) == '1' || num.charAt(index + 2) == '2' && num.charAt(index + 1) < '7')) {
            res += getNumberOfWays(num, index + 2, memo);
        }
        return memo[index] = res;
    }

}
