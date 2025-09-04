import java.util.ArrayList;
import java.util.List;

public class ExtractIntegers {
    public static void main(String[] args) {
        String text1 = "cv dd 4 k 2321 2 11 k4k2 66 4d";
        List<Integer> ints = extractInts(text1);
        System.out.println(" original : " + text1 + " only ints : ");
        ints.forEach(System.out::println);
    }

    static List<Integer> extractInts(String text) {
        int len = text.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (i < len) {
            if (Character.isDigit(text.charAt(i))) {
                sb.append(text.charAt(i));
            } else {
                if (!sb.isEmpty()) {
                    list.add(Integer.parseInt(sb.toString()));
                    sb.delete(0, sb.length());
                }
            }
            i++;
        }
        System.out.println(sb);
        return list;
    }
}