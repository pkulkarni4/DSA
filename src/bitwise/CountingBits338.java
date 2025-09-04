package bitwise;

public class CountingBits338 {
}
class SolutionCountingBits338 {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        countBits(n, 1, 1, result);
        return result;
    }

    static void countBits(int n, int start, int count, int[] result)
    {
        if (start > n) return;
        result[start] = count;
        start <<= 1;
        countBits(n, start, count, result);
        countBits(n, start + 1, count + 1, result);
    }
}
class Solution {
    public int[] countBits(int n) {
        //return countBitsByLoop(n);
        //return countBitsByDP(n);
        return countBitsByDP1(n);
    }

    int[] countBitsByDP1(int n) {
        int ans[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    int[] countBitsByDP(int n){
        int[] dp = new int[n+1];
        int offset =1;

        for(int i =1;i<=n;i++) {
            if(offset*2 == i) offset = i;
            dp[i] = 1+dp[i-offset];
        }
        return dp;
    }

    int[] countBitsByLoop(int n){ // nlogn
        int[] ret = new int[n+1];

        for(int i=0;i<=n;i++){
            ret[i] = count(i);
        }
        return ret;
    }
    int count(int n) {
        int count =0;
        while(n>0){
            n=n&n-1;
            count++;
        }
        return count;
    }
}
