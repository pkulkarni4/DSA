package chapter08;

import java.util.HashMap;

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWaysSolution s = new DecodeWaysSolution();
        int n = s.getNumberOfWays("121015");
        System.out.println(n);
    }
}

class DecodeWaysSolution {

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
        if(usememo){
            int len = num.length();
            int[] memo = new int[len];
            getNumberOfWays(num, 0, memo);
        }

        return getNumberOfWays(num, 0);
    }

    private int getNumberOfWays(String num, int index, int[] memo) {
        int len = num.length();
        if(len == index) return 1;
        if(num.charAt(index) == '0') return 0;
        if(memo[index] != 0) return memo[index];
        int res = getNumberOfWays(num, index+1, memo);
        if(index<len-1 && (num.charAt(index) == '1' || num.charAt(index+2) == '2' && num.charAt(index+1) < '7')) {
            res += getNumberOfWays(num, index+2, memo);
        }
        return memo[index] = res;
    }

}
