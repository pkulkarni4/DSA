package leetcode;

public class BalancedString1221 {
    public static void main(String[] args) {
        SolutionBalancedString1221 s1 = new SolutionBalancedString1221();
        s1.balancedStringSplit("RLRRLLRLRL");
        s1.balancedStringSplit("RLRRRLLRLL");
        s1.balancedStringSplit("LLLLRRRR");
        s1.balancedStringSplit("RRRR");
    }
}

class SolutionBalancedString1221 {
    public int balancedStringSplit(String s) {
        if(s == null || s.length() <= 1) return 0;

        int rCount = 0, lCount = 0, balStringCount = 0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == 'R') {
                rCount++;
            } else {
                lCount++;
            }
            if(rCount == lCount){
                balStringCount++;
                rCount=0;
                lCount=0;
            }
        }
        System.out.println("s:  " + s + "  : " + balStringCount);
        return balStringCount;

    }
}
