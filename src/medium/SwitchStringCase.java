package medium;

public class SwitchStringCase {
    public static void main(String[] args) {
        SwitchStringCaseSolution ss = new SwitchStringCaseSolution();
        String result = ss.transformString("hELlO wOrLD 123");
        System.out.println(result);
    }
}

class SwitchStringCaseSolution {
    public String transformString(String s) {
        String result = null;
        if(s == null || s.length() == 0) return result;

        int length = s.length();
        // A = 65, Z = 90
        // a = 97, z = 122
        char[] res = new char[length];
        for(int i=0;i<length; i++) {
            char c = s.charAt(i);
            if (c - 'a' >= 0) { // lower case
                res[i] = (char) (c-32);
            } else if (c - 'A' >= 0){ // upper case
                res[i] = (char) (c+32);
            } else {
                // not alphabet
                res[i] = c;
            }
        }

        return new String(res);
    }
}