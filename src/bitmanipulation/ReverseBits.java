package bitmanipulation;

/*
LC #190 : Reverse bits
 */
public class ReverseBits {
    public static void main(String[] args) {

        int[] examples = {
                43261596,
                2147483644
        };
        ReverseBits190Solution s = new ReverseBits190Solution();
        for (int i : examples) {
            int rev = s.reverseBits(i);
            System.out.println(rev);
        }
    }
}

class ReverseBits190Solution {

    public int reverseBits(int n) {
        if (n == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}