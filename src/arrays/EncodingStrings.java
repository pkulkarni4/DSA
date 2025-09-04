package arrays;

public class EncodingStrings {
    public static void main(String[] args) {
        String str = " String   with   spaces   test";
        EncodingStringsSolution s = new EncodingStringsSolution();
        String encodedString = new String(s.encodeString(str.toCharArray()));
        System.out.println(encodedString);
    }
}

class EncodingStringsSolution {
    /**
     * Consider a string str = " String with   spaces". each space takes up 1 space where as %20 will take up 3. 3-1=2, we will need 2 spaces extra to accommodate
     * Step 1: count spaces
     * Step 2: create new char[] with original len + 2 times spaces
     * Step 3: loop thru the str and replace space with %20
     **/
    public char[] encodeString(char[] str) {
        // count spaces:
        int spaceCount = 0;
        int length = str.length;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int requiredSpace = length + spaceCount * 2;
        char[] encodedStr = new char[requiredSpace];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str[i])) {
                encodedStr[index] = '%';
                encodedStr[index + 1] = '2';
                encodedStr[index + 2] = '0';
                index += 3;
            } else {
                encodedStr[index] = str[i];
                index += 1;
            }
        }
        return encodedStr;
    }
}
