import java.util.Arrays;
import java.util.Scanner;

public class NightAtAMuseum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char current = 'a';
        String str = sc.next();
        int minSteps = 0;
        for(int i=0;i<str.length();i++) {
            char nextChar = str.charAt(i);
            int clockwise = Math.abs((current - nextChar));
            if(clockwise < 13){
                minSteps += clockwise;
            } else {
                minSteps += 26-clockwise; // anticlockwise
            }
            current = nextChar;
        }
        System.out.println(minSteps);
    }
}
