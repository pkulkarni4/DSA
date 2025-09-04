import java.util.Scanner;

public class BlackSquare {
    public static void main(String[] args) {
        // test data
        int[] a = new int[4];
        //String str = "11221";
        //
        Scanner sc = new Scanner(System.in);
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();
        a[2] = sc.nextInt();
        a[3] = sc.nextInt();
        String str = sc.next();
        int calories = 0;
        for (int i = 0; i < str.length(); i++) {
            calories += a[(int) str.charAt(i) - 49];
        }
        System.out.println(calories);
    }
}
