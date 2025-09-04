package arrays;

public class OneEditAway {
    public static void main(String[] args) {
        OneEditAwaySolution s = new OneEditAwaySolution();
        String text1 = "tank";
        // true
        String text2 = "thank"; // inserted
        String text3 = "bank"; // replaced
        String text4 = "tan"; // removed
        // false
        String text5 = "thankless";
        String text6 = "kant";
        String text7 = "ant";

        boolean v = s.isOneEditAway(text1, text2);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text2 + "  " + (v ? " yes " : " no "));

        v = s.isOneEditAway(text1, text3);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text3 + "  " + (v ? " yes " : " no "));

        v = s.isOneEditAway(text1, text4);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text4 + "  " + (v ? " yes " : " no "));

        v = s.isOneEditAway(text1, text5);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text5 + "  " + (v ? " yes " : " no "));

        v = s.isOneEditAway(text1, text6);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text6 + "  " + (v ? " yes " : " no "));

        v = s.isOneEditAway(text1, text7);
        System.out.println(" text 1" + text1 + "  is one edit away from  text 2: " + text7 + "  " + (v ? " yes " : " no "));
    }
}

class OneEditAwaySolution {
    /**
     * whether we can obtain two identical strings by performing a single edit in q or p. we insert, remove or replace a single character in q or p.
     */
    public boolean isOneEditAway(String q, String p) {

        // difference of lens == +/- 1 or zero (replaced)
        int i = 0, j = 0, diff = 0, qLen = q.length(), pLen = p.length();
        if (Math.abs(qLen - pLen) > 1) {
            return false;
        }

        String shorterStr = qLen < pLen ? q : p;
        String longerStr = qLen < pLen ? p : q;

        while (i < shorterStr.length()) {
            if (shorterStr.charAt(i) == longerStr.charAt(j)) {
                i++;
                j++;
            } else {
                diff++;
                if (shorterStr.length() == longerStr.length()) {
                    i++;
                }
                j++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }
}
