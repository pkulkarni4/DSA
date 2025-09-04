package bitmanipulation;

/**
 * Problem: Consider a 32-bit integer, n. A sequence of 101 can be considered 111.
 * Write a snippet of code that computes the length of the longest sequence of 1.
 */
public class LongestSequenceOf1 {
    public static void main(String[] args) {

        int ls1 = sequence(67534);
        System.out.println("longest sequence of 1 : " + ls1);

        ls1 = sequence(65);
        System.out.println("longest sequence of 1 : " + ls1);

        ls1 = sequence(339809);
        System.out.println("longest sequence of 1 : " + ls1);

        ls1 = sequence(Integer.MAX_VALUE);
        System.out.println("longest sequence of 1 : " + ls1);
    }

    // idea is to right shift by 1 & 1, if it is 1, the increment the count
    // only catch is sequence 101
    // do 101 & 010, if it is 0
    static int sequence(int n) {
        if (~n == 0) {
            return Integer.SIZE;
        }
        int currSeq = 0, longSeq = 0;
        boolean flag = true;
        while (n != 0) {
            if ((n & 1) == 1) {
                currSeq++;
                flag = false;
            } else if ((n & 1) == 0) {
                currSeq = ((n & 2) == 0) ? 0 : flag ? 0 : ++currSeq;
                flag = true;
            }
            longSeq = Math.max(currSeq, longSeq);
            n >>>= 1;
        }
        return longSeq;
    }

}
