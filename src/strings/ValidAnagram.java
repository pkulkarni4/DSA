package strings;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagramSolution s = new ValidAnagramSolution();
        boolean b = s.isAnagram("rat", "car");
        System.out.println(b);
    }
}

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for (char c : s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            alphabets[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                return false;
            }
        }
        return true;
    }
}