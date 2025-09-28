package others;

public class ReverseInteger7 {
    public static void main(String[] args) {
        ReverseInteger7Solution s = new ReverseInteger7Solution();
        int[] input = {123, 120, 12, -123, 1534236469};
        for (int i : input) {
            System.out.println("reverse of " + i + " is ==>" + s.reverse(i));
        }
    }
}

class ReverseInteger7Solution {
    public int reverse(int x) {
        int rev = 0;
        if (x == 0) return rev;
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }
}