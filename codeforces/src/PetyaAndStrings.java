import java.util.Locale;
import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        int output = str1.compareToIgnoreCase(str2);
        if(output < 0){
            output = -1;
        } else if(output > 0){
            output = 1;
        }

        //System.out.println(output);

        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        char[] s1Chars = new char[26];
        char[] s2Chars = new char[26];

        for(int i=0;i<s1.length();i++){
            s1Chars[s1.charAt(i) - 'a']++;
            s2Chars[s2.charAt(i) - 'a']++;
        }
        //compare the strings
        for(int i=0;i<26;i++){
            if(s1Chars[i] != s2Chars[i]){
                output += s1Chars[i] - s2Chars[i];
            }
        }

        System.out.println(output);
    }

}
