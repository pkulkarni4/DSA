package bitmanipulation;

public class TestBinaryRep {
    public static void main(String[] args) {
        ConvertToBinary cb = new ConvertToBinary();
        System.out.println(" binary of 51 : " + cb.toBinary(51));
        System.out.println(" binary of 51 : " + cb.toBinary(-5));
        System.out.println(" decimal : " + cb.toDecimal("110011"));
        /// ///

        BitwiseOperation op = new BitwiseOperation();
        boolean b = op.isPowerOfTwo(11);
        System.out.println(b);

        b = op.isOdd(11);
        System.out.println(b);

        b = op.isEven(12);
        System.out.println(b);

    }
}

/**
 * negative numbers -
 * 5 is represented as 101, -5 as 1011
 * How to convert -ve number to binary:
 * 1. flipping 101 to 010
 * 2. add 1 - 011
 * 3. append 1 to left most bit - 1011
 */
class ConvertToBinary {
    public String toBinary(int i) {
        return Integer.toBinaryString(i); // or Integer.toString(51, 2)
    }

    public int toDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}

/**
 *
 ~ : negates -> 0 to 1 and 1 to 0. for example 5: 101, ~5 becomes 01
 * <p>
 & : compares bit by bit , returns 1 only if both bits are 1. ex: 101 & 111 = 101. 5 & 7 = 5
 * <p>
 |:  compares bit by bit , returns 1 only if one of the bits is 1. ex: 101 | 111 = 111. 5 | 7 = 7
 * <p>
 ^ (xor):  compares bit by bit , returns 1 only if bits are different. ex: 101 ^ 111 = 010. 5 ^ 7 = 2

 X | Y | X&Y | X|Y | X^Y | ~X
 0 | 0 | 0   | 0   |  0  | 1
 0 | 1 | 0   | 1   |  1  | 1
 1 | 0 | 0   | 1   |  1  | 0
 1 | 1 | 1   | 1   |  0  | 0
 *
 *
 * Tricks
 * one-liner code   | Function
 *   x & 1          | odd if value is 1 and even if 0
 *   x & (x-1)      |
 *   x >> 1         | divide x by 2
 *   x << 1         | multiply x by 2
 *   ch | ''        | upper to lower case
 *   ch & '_'       | lower to upper
 *
 */

class BitwiseOperation {

    public boolean isPowerOfTwo(int x) {
        //System.out.println(x && !(x & x-1));
        return false;
    }

    public boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    public boolean isEven(int x) {
        return (x & 1) == 0;
    }

}


/**
 *
 * <p>
 *     Signed Left Shift << : Left shifting a number by n positions is equivalent to multiplying by 2^n. Ex: 23<<3 = 23 * 8 = 184.
 *     Left shifting by number greater than 32 will be modulo and reduced to
 *     to smaller number. For ex: 23 << 35 = 23 << (35%32) = 23 << 3
 *
 *     Signed Right Shift >> : right shifting a number n positions is equivalent to dividing by 2^n. Ex: 24 >> 3 = 24/8 = 3. modulo rule still applies.
 *
 *     Unsigned Right Shift >>>:
 *  </p>
 */
class BitShiftOperation {

}