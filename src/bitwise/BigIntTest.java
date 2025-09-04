package bitwise;

import java.math.BigInteger;

public class BigIntTest {
    public static void main(String[] args) {
        Integer j = -3;
        String bin = Integer.toBinaryString(j);
        BigInteger bi = new BigInteger(bin);
        System.out.println(bi.bitCount());

        System.out.println(bin);
        int count=0;
        for(int i = 0; i<bin.length(); i++) {
            if(bin.charAt(i) == '1') count++;
        }

        System.out.println("count of 1 bit:  " + count);

        int count1 = 0, mask = 1;
        int n =-3;
        for (int i = 0; i <32; i++){
            if((n & mask) != 0 ) count1++;
            mask = mask <<1;
        }
        System.out.println("count of 1 bit:  " + count1);

    }
}
