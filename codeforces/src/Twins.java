import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] coins = new Integer[n];
        int totalValue = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            totalValue += coins[i];
        }
        // sort coins desc
        Arrays.sort(coins, Collections.reverseOrder());
        int i = 0,  sumTwin1 = 0;

        while (sumTwin1 <= (totalValue - sumTwin1)) {
            sumTwin1 += coins[i];
            i++;
        }
        System.out.println(i) ;

    }
}
