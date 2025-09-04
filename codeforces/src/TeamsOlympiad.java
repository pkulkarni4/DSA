import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamsOlympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

       // int[] arr = new int[len];
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<Integer> three = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                one.add(i + 1);
            } else if (num == 2) {
                two.add(i + 1);
            } else {
                three.add(i + 1);
            }
        }
        int teams = Math.min(one.size(), Math.min(two.size(), three.size()));
        System.out.println(teams);
        for (int i = 0; i < teams; i++) {
            System.out.print(one.get(i) + " " + two.get(i) + " " + three.get(i) + "\n");
        }

    }
}
