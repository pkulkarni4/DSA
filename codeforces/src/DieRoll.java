import java.util.Scanner;

public class DieRoll {
    public static void main(String[] args) {
        String[] arr = {"1/6", "1/3", "1/2", "2/3", "5/6", "1/1"};
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt(), w = sc.nextInt();
        int m = Math.max(y, w);
        System.out.println(arr[6 - m]);
    }
}
