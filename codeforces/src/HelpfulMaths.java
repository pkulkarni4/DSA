import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int onecount = 0, twocount = 0, threecount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                onecount++;
            } else if (c == '2') {
                twocount++;
            } else if (c == '3') {
                threecount++;
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < onecount; i++) {
            output.append("1");
            if (i < onecount - 1) {
                output.append("+");
            }
        }

        if (onecount > 0 && twocount > 0) {
            output.append("+");
        }

        for (int i = 0; i < twocount; i++) {
            output.append("2");
            if (i < twocount - 1) {
                output.append("+");
            }
        }

        if ((onecount > 0 || twocount > 0) && threecount > 0) {
            output.append("+");
        }
        for (int i = 0; i < threecount; i++) {
            output.append("3");
            if (i < threecount - 1) {
                output.append("+");
            }
        }
        System.out.println(output);
    }
}
