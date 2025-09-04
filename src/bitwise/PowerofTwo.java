package bitwise;

public class PowerofTwo {
    public static void main(String[] args) {
        SolutionPowerofTwo s = new SolutionPowerofTwo();
        int x = 16;
        boolean b = s.isPowerofTwoIteration(x);
        if(b) System.out.println(x + " is power of two");
        else System.out.println(x + " is not power of two");
    }
}

class SolutionPowerofTwo{

    public boolean isPowerofTwoIteration(int x) {
        if(x==0) return false;
        while(x%2 ==0) x=x/2;
        return (x==1);
    }

    public boolean isPowerOfTwoBit(int x) {
        return (x>0 && (x & (x-1))==0);
    }
}
