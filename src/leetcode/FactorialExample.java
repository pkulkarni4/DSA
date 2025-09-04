package leetcode;

public class FactorialExample {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        int n = f.factorial_Loop(5);
        System.out.println(n);

        n = f.factorial_Rec(5);
        System.out.println(n);
    }
}

class Factorial {
    public int factorial_Loop(int n){
        int fact = 1;
        for(int i=n;i>1;i--) {
            fact = fact *i;
        }
        return fact;
    }

    public int factorial_Rec(int n) {
        if (n <= 1) return 1;
        return n * factorial_Rec(n-1);
    }
}
