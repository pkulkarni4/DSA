package bitwise;

public class BitwiseExamples {
    public static void main(String[] args){
        Bitwise b = new Bitwise();
        b.OR(5, 7);
        b.AND(5, 7);
        b.XOR(5, 7);
        b.complement(5);
        b.leftShiftBy1(2); // multiply by 2
        b.leftShift(21,1); // multiply by 2
        b.rightShiftBy1(6); // divide by 2
        b.rightShift(8, 30); // divide by 2
        String bin = b.decToBinary(5);
        b.binToDec(Integer.valueOf(bin));
        b.count_one(15);
        b.checkIfBitPosIsSet(5,0);
        b.checkIfBitPosIsSet(5,1);
        b.checkIfBitPosIsSet(5,2);
        b.checkIfBitPosIsSet(5,3);
        //////

        /// Arithmetic operation on binary

        ///
        String five =  "0101";
        String seven = "0111";
        b.add(five, seven);
    }
}

class Bitwise {
    public int OR(int a, int b) {
        int ret = a|b;
        System.out.println(a+" OR "+b +" = " + ret);
        return ret;
    }

    public int AND(int a, int b) {
        int ret = a&b;
        System.out.println(a+" AND "+b + " = " + ret);
        return ret;
    }

    public int XOR (int a, int b) {
        int ret = a^b;
        System.out.println(a+" XOR "+b + " = " + ret);
        return ret;
    }

    public int rightShiftBy1(int n) {
        return rightShift(n, 1);
    }

    public int rightShift(int n, int i) {
        int ret = n >> i;
        System.out.println(n+" >> "+ i + " = " + ret);
        return ret;
    }

    public int leftShiftBy1(int n) {
        return leftShift(n, 1);
    }

    public int leftShift(int n, int i) {
        int ret = n << i;
        System.out.println(Integer.toBinaryString(n)+" << "+ i + " = " + Integer.toBinaryString(ret));
        return ret;
    }

    public String decToBinary(int n)
    {
        StringBuilder sb = new StringBuilder();
        // Size of an integer is assumed to be 32 bits
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                sb.append("1");
            else
                sb.append("0");
        }
        System.out.println("binary of "+n +" is: "+sb);
        return sb.toString();
    }

    public int binToDec(Integer val) {
        int dec = 0, temp = val, base = 1;
        while(temp > 0){
            int last=temp%10;
            temp = temp/10;
            dec = dec + base * last;

            base = base * 2;
        }
        System.out.println("binary value: "+val + "  decimal value: "+dec);
        return dec;
    }

    public int complement(int i) {
        int ret = ~i;
        System.out.println("2's complement of "+i + " is : "+ret);
        return ret;
    }

    public String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int a_len = a.length();
        int b_len = b.length();
        int i=a_len-1, j=b_len-1, carry=0;
        //
        while(i>=0 || j>=0) {
            int sum = carry;
            if(i>=0) { sum = sum + a.charAt(i) -'0';}
            if(j>=0) {sum = sum + b.charAt(j) -'0';}
            sb.append(sum%2);
            carry = sum/2;

            i--;
            j--;
        }
        if(carry!=0) sb.append(carry);

        String res = sb.reverse().toString();
        System.out.println(a+" + "+b + " = " + res);
        return res;
    }

    int count_one(int n) {
        int temp = n;
        int count =0;
        while(temp>0) {
            temp = temp&(temp-1);
            // System.out.print(" "+temp);
            count++;
        }
        System.out.println( n + " has "+count + " 1s");
        return count;
    }

    boolean checkIfBitPosIsSet(int n, int pos) {
        boolean b = ((n & (1 << pos)) > 0);
        if(b) System.out.println(pos+"th bit of "+n+" is set to 1");
        else System.out.println(pos +"th bit of "+ n +" is 0");
        return b;
    }


}
