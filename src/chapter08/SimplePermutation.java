package chapter08;

public class SimplePermutation {
    public static void main(String[] args) {
        permute("", "abc1");
    }

    static void permute(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }
}
