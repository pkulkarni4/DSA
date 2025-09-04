package medium;

public class StringSwapAdjacentChars {
    public static void main(String[] args) {
        StringSwapAdjacentCharsSolution ss = new StringSwapAdjacentCharsSolution();
        String res = ss.swapPairs("abcdef");
        System.out.println(res);

        res = ss.swapPairs("hello");
        System.out.println(res);
    }
}
class StringSwapAdjacentCharsSolution {
    public String swapPairs(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        char[] chars = new char[len];
        String res = "";
        for(int i = 0 ;i<len; i++) {
            if(i+1 < len){
                res = res + s.charAt(i+1) + s.charAt(i)+"";
                i++;
            }else{
                res = res + s.charAt(i);
            }
        }
        return res;
    }
}