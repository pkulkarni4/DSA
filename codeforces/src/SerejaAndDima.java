import java.util.Scanner;

public class SerejaAndDima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // int n = sc.nextInt();
        int n = 42;
        int s = 0, d = 0;
        //int[] cards = new int[n];
        Integer[] cards = {15, 29, 37, 22, 16, 5, 26, 31, 6, 32, 19, 3, 45, 36, 33, 14, 25, 20, 48, 7, 42, 11, 24, 28, 9, 18, 8, 21, 47, 17, 38, 40, 44, 4, 35, 1, 43, 39, 41, 27, 12, 13};
       // for (int i = 0; i < n; i++) {
      //      cards[i] = sc.nextInt();
     //   }
        int next = n - 1;
        int i = 0;
        int turn = 0;
        while (i <= next) {
            if (cards[i] >= cards[next]) {
                if (turn % 2 == 0) s += cards[i];
                else d += cards[i];
                i++;
            } else {
                if (turn % 2 == 0) s += cards[next];
                else d += cards[next];
                next--;
            }
            turn++;

        }
        System.out.println(s + " " + d);
    }
}
