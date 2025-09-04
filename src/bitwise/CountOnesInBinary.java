package bitwise;

public class CountOnesInBinary {
    public static void main(String[] args) {
        SolutionCountOnesInBinary b = new SolutionCountOnesInBinary();
        int n = 5;
        int count = b.countOnesInBinary(n);
        System.out.println(n + " has "+count+" 1s");
    }
}

class SolutionCountOnesInBinary {
    public int countOnesInBinary(int n){
        int count = 0;
        while(n > 0) {
            n = n& n-1;
            count++;
        }
        return count;
    }
}
