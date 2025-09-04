package bitmanipulation;

public class SetTheBit {
    public static void main(String[] args) {
       int n =  setValueTo1(9, 3);
        System.out.println(n);
    }

    static int setValueTo1(int n, int k) {
        return n | (1 << k);

    }
}
