package arrays;

public class ShrinkingAString {
    public static void main(String[] args) {
        ShrinkingAStringSol ss = new ShrinkingAStringSol();
        String text1 = "aaaa b";
        String text2 = "abbb accc vvvv a";
        String text3 = "abcd";
        String text4 = "abbb vvvv s rttt rr eeee f";
        System.out.println("original : " + text1 + " final : " + ss.shrink(text1));
        System.out.println("original : " + text2 + " final : " + ss.shrink(text2));
        System.out.println("original : " + text3 + " final : " + ss.shrink(text3));
        System.out.println("original : " + text4 + " final : " + ss.shrink(text4));
    }
}

class ShrinkingAStringSol {
    /**
     * given a string : abbb vvvv s rtttt eeee f, shrink and return
     * a1b3 v4 s1 r1t4 e4 f1
     * <p>
     * if cannot shrink (resulting string is longer than input), return original string.
     */
    public String shrink(String str) {
        int len = str.length(), i = 0, count = 1;
        StringBuilder res = new StringBuilder();
        while (i < len - 1) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else if (Character.isWhitespace(str.charAt(i))) { // if we don't do this, space will be counted!
                res.append(" ");
            } else {
                res.append(str.charAt(i)).append(count);
                count = 1;
            }
            i++;
        }

        // append last char
        res.append(str.charAt(len - 1)).append(count);

        return res.toString().length() > len ? str : res.toString();
    }
}