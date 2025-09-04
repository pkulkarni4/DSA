package medium;

public class StringShiftToNextChar {
    public static void main(String[] args) {
        StringShiftToNextCharSolution ss = new StringShiftToNextCharSolution();
        String res = ss.shiftByOneCharacter("abz123ABZ");
        System.out.println(res);
    }
}
class StringShiftToNextCharSolution {
    public String shiftByOneCharacter(String s) {
        String result = null;
        if(s == null || s.length() == 0) return result;

        int length = s.length();
        char[] res = new char[length];
        for(int i=0;i<length; i++) {
            char c = s.charAt(i);
            if(c - 'a' >= 0) {
                // only alphabets, shift to next
                if( c == 'z'){
                    res[i] = 'a';
                } else {
                    res[i] = (char) (c + 1);
                }
            } else if (c - 'A' >= 0){
                if( c == 'Z'){
                    res[i] = 'A';
                } else {
                    res[i] = (char) (c + 1);
                }
            } else {
                // other chars, keep as is
                res[i]=c;
            }
        }
        return new String(res);
    }
}