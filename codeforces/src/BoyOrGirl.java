import java.util.Scanner;

public class BoyOrGirl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = new char[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            int j = (chars[i] >= 1) ? 1 : 0;
            count = count + j;
        }
        if (count % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
