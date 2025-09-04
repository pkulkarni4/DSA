import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        // equal number of lower and upper case letters --> lower case
        // else -> upper case
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int lowerCaseLetters = 0, upperCaseLetters = 0;
        for(char c: str.toCharArray()){
            if(isUpperCase(c)){
                upperCaseLetters++;
            } else {
                lowerCaseLetters++;
            }
        }
        if(lowerCaseLetters >= upperCaseLetters) {
            System.out.println(str.toLowerCase());
        } else {
            System.out.println(str.toUpperCase());
        }
    }

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
