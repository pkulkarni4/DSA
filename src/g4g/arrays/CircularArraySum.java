package g4g.arrays;

public class CircularArraySum {
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        int sum = circularSum(arr, arr.length);
        System.out.println(sum);
    }

    // O(n^2)
    static int circularSum(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            for(int j=0;j<n;j++){
                int idx = (i+j)%n;
                currSum = currSum + arr[idx];
                res=Math.max(currSum, res);
            }
        }
        return res;
    }
}
