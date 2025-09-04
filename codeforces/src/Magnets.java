import java.util.Scanner;

public class Magnets {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int group = 1;
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        for (int i = 0; i < n-1; i++) {
            if(!strs[i].equals(strs[i+1])){
                group = group + 1;
            }
        }
        System.out.println(group);
    }
}
