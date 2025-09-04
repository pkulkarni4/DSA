import java.util.Scanner;

public class UncommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        if(a.equals(b)) {
            System.out.println(-1);
        } else if (a.length()>b.length()){
            System.out.println(a.length());
        } else {
            System.out.println(b.length());
        }
    }
}
