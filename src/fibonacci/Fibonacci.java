package fibonacci;

public class Fibonacci {
    public static void main(String[] args){
        FibonacciRecursive fr = new FibonacciRecursive();
        int n = 15;
       // fr.printFibonacciSeries(n);
       FibonacciRecursiveWithMemoization frm = new FibonacciRecursiveWithMemoization();

        frm.printFibonacciSeries(n);
    }
}

class FibonacciRecursive {


    public void printFibonacciSeries(int n) {
        System.out.println(" ");
        for(int i=0;i<n;i++) {
            System.out.print(" "+fibRecursive(i));
        }
    }

    private int fibRecursive(int i) {
        if(i == 0) return 0;
        if(i == 1 || i == 2) return 1;

        return fibRecursive(i-1) + fibRecursive(i-2);
    }
}
class FibonacciRecursiveWithMemoization {


    public void printFibonacciSeries(int n) {
        int[] mem = new int[n];// [0,0,0,0,0]
        System.out.println(" ");
        for(int i=0;i<n;i++) {
            System.out.print(" "+fibRecursive(i, mem));
        }
    }

    private int fibRecursive(int n, int[] mem) {
        if(mem[n]!=0) return mem[n];

        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        mem[n] = fibRecursive(n-1, mem) + fibRecursive(n-2, mem);
        System.out.println(" mem["+n+ "]"+ mem[n]);
        return mem[n];
    }
}
