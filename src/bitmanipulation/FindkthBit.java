package bitmanipulation;

public class FindkthBit {
    public static void main(String[] args) {
        FindkthBitSol s = new FindkthBitSol();
        char c = s.getkthBit(423, 7);
        System.out.println(c);
    }
}

class FindkthBitSol {
    public char getkthBit(int n, int k){
        int result = n & (1 << k); // can also use:  1 & (n >> k);
        if(result == 0) return '0';
        return '1';
    }

}