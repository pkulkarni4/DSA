import java.util.Scanner;

public class LinelandMail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // a is sorted
        for (int i = 0; i < n; i++) {

            if(i==0){

            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int a1 = a[i] - a[j];
                    min = Math.min(Math.abs(a1), min);
                    max = Math.max(Math.abs(a1), max);
                }
            }
            System.out.println(min + " " + max);
        }
    }
}
