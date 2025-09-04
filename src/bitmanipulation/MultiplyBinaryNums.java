package bitmanipulation;

public class MultiplyBinaryNums {
    public static void main(String[] args) {
        MultiplyBinaryNumsSol s = new MultiplyBinaryNumsSol();

        int m = s.multiply(5, 5);
        System.out.println(m);
    }
}

class MultiplyBinaryNumsSol {
    public int multiply(int q, int p) {
        int res = 0;
        while (p != 0) {
            if ((p & 1) != 0) {
                res = res + q;
                System.out.println(" res: " + res);
            }
            q = q << 1;
            System.out.println(" q : " + q);
            p = p >>> 1;
            System.out.println(" p: " + p);
        }
        return res;
    }
}