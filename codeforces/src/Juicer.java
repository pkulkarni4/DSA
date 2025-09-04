import java.util.Scanner;

public class Juicer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), maxSize = sc.nextInt(), d = sc.nextInt(), emptyCount = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            int orange = sc.nextInt();
            if (orange > maxSize) continue;


            sum += orange;

            if (sum > d) {
                emptyCount++;
                sum = 0;
            }
        }
        System.out.println(emptyCount);
    }
}
