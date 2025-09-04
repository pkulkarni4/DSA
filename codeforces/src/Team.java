import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://codeforces.com/contest/231/problem/A">A. Team </a>
 */
public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int output = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int v = sc.nextInt();
            int t = sc.nextInt();
            output += ((p + v + t) >= 2) ? 1 : 0;
        }

        out.println(output);
        out.close();
    }
}
