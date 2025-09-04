package leetcode;

public class OneAway {
    public static void main(String[] args) {
        String s1 = "pale", s2 = "sale";
        boolean b = isOneEditAway(s1, s2);
        System.out.println(b?"yes":"no");
        s1 = "sale"; s2 = "sale1";
        b = isOneEditAway(s1, s2);
        System.out.println(b?"yes":"no");
        s1 = "bake"; s2 = "sale1";
        b = isOneEditAway(s1, s2);
        System.out.println(b?"yes":"no");

    }

    private static boolean isOneEditAway(String s1, String s2) {
        int i=0,j=0,count=0;
        int s1length = s1.length();
        int s2len = s2.length();
        while(i< s1length && j< s2len) {
            if(s1.charAt(i) != s2.charAt(j)) {
                count++;
            }
            i++;j++;
        }
        if(s1length -i != 0) count+= s1length -i;
        if(s2len -j != 0) count+= s2len -j;

        return count<=1 ;
    }
}
