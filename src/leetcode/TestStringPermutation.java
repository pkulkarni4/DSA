package leetcode;

public class TestStringPermutation {
    public static void main(String[] args) {
        StringPerm s = new StringPerm();
        s.permutation("abca");
    }
}

class StringPerm {
    public void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if(str.length() == 0)
            System.out.println(prefix);
        else {
            for (int i=0;i<str.length();i++){
                String rem = str.substring(0, i) + str.substring(i+1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
