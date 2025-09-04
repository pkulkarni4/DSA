package leetcode;

public class RichestCustomer1672 {
    public static void main(String[] args){
        int[][] acc = {{1, 2}, {3, 1}};
        int maxW = maximumWealth(acc);
        System.out.println("maxW: " + maxW);
       int[][] acc1 = {{1,2,3},{3,2,1}};
         maxW = maximumWealth(acc1);
        System.out.println("maxW 1: " + maxW);
       int[][] acc2 = {{1,5},{7,3},{3,5}};
         maxW = maximumWealth(acc2);
        System.out.println("maxW 2: " + maxW);
        int[][] acc3 = {{2,8,7},{7,1,3},{1,9,5}};
         maxW = maximumWealth(acc3);
        System.out.println("maxW 3: " + maxW);
    }

    public static int maximumWealth(int[][] accounts) {
        if(accounts == null || accounts.length == 0) return 0;
        return extracted(accounts, accounts.length, accounts[0].length);
    }

    private static int extracted(int[][] accounts, int row, int col) {
        int sum=0, max=-1;

        for(int i = 0; i< row; i++) {
            for (int j = 0; j< col; j++) {
                sum = sum + accounts[i][j];
            }
            if(sum>max) max = sum;
            sum=0;
        }
        return max;
    }

}
