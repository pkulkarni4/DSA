import java.util.Scanner;

public class Pangram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        if(len > 25) {
            str = str.toLowerCase();
            char[] chars = new char[len];
            for (int i = 0; i < len; i++) {
                chars[str.charAt(i) - 'a']++;
            }
            String output = "YES";
            for (char c = 0; c < 26; c++) {
                if (chars[c] == 0) {
                    output = "NO";
                    break;
                }
            }
            System.out.println(output);
        } else {
            System.out.println("NO");
        }
    }
}
