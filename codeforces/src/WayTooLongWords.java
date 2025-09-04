import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            extracted(words[i]);
        }
    }

    private static void extracted(String inputWord) {
        int length = inputWord.length();
        if (length < 11) {
            System.out.println(inputWord);
        } else {
            String x = inputWord.charAt(0) + "" + (length - 2) + inputWord.charAt(length - 1);
            System.out.println(x);
        }
    }
}
