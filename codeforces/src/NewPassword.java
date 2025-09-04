import java.util.Scanner;

public class NewPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); // total characters
        int dist = sc.nextInt(); // distinct characters

        char[] alphabets = new char[26];

        int count = 0;
        for (char i = 'a'; i <= 'x'; i++) {
            alphabets[count++] = i;
        }

// wrong answer The number of different letters must be equal to k
        StringBuilder output = new StringBuilder();
        int i = 0, j = 0;

        while(i<len-dist || j < dist){
            if(i<len-dist){

                // append "z"
                output.append("z");

                if(j == dist) {
                    // all distinct chars are put in place, its just repeated zy zy
                    output.append("y");
                }
                i++;
            }

            if(j < dist){
                // append dist chars
                output.append(alphabets[j]);
                j++;
            }
        }



        System.out.println(output);
    }
}
