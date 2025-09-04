package others;

public class Palindrome {
    public static void main(String[] args) {
        boolean b = isPalindrome("racecar");
        System.out.println(b);
    }

    private static boolean isPalindrome(String str) {
        int len = str.length()-1;
        for(int i = 0; i<=len/2; i++) {
            if(str.charAt(len-i) != str.charAt(i))
                return false;
        }
        return true;
    }

}
