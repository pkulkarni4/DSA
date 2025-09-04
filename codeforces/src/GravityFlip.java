import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = sc.nextInt();
        }
        Arrays.sort(output);
        for (int i : output)
            System.out.print(i + " ");


    }
}