package leetcode;

public class ShuffleString1528 {
    public static void main(String[] args){
        String s = "codeleet";
        int[] ar = {4,5,6,7,0,2,1,3};

        String res = restoreString2(s, ar);
        System.out.println(res);

         s = "abc";
         int[] ar1 = {1,2,0};

         res = restoreString2(s, ar1);
        System.out.println(res);
    }

    public static String restoreString1(String s, int[] indices) {
        if (s == null || s.length() == 0 || indices == null || indices.length == 0) return s;
        int len = indices.length;
        char[] chr = new char[len];

        for(int i=0;i<len;i++) {
            chr[indices[i]] = s.charAt(i);
        }
        return new String(chr);
    }

    static String restoreString2(String s, int[] indices) {
        if (s == null || s.length() == 0 || indices == null || indices.length == 0) return s;
        int len = indices.length;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<len;i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }
}
