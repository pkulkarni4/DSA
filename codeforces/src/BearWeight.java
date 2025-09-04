import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BearWeight {
    public static PrintWriter out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int l = sc.nextInt();
        int b = sc.nextInt();

        int lWt = l;
        int bWt = b;
        int cnt = 0;
        while (lWt <= bWt){
            bWt = bWt * 2;
            lWt = lWt * 3;
            cnt = cnt + 1;
        }
        out.println(cnt);

        out.close();
    }
}
