import java.util.Scanner;

public class FreeIceCream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalPacks = sc.nextInt(), distressedKid = 0;
        for (int i = 0; i < n; i++) {
            String sign = sc.next();
            int pack = sc.nextInt();
            if ("+".equals(sign)) {
                totalPacks += pack;
            } else {
                if (pack > totalPacks) {
                    distressedKid++;
                } else {
                    totalPacks -= pack;
                }
            }
        }
        System.out.println(totalPacks + " " + distressedKid);
    }
}
