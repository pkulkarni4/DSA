import java.util.Scanner;

public class ColorfulStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();;
        int pos = 0, i = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(pos)) {
                pos++; // move position
            }
            i++; // next instr
        }
        System.out.println(pos+1);
    }
}
