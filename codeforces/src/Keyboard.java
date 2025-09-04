import java.util.*;

public class Keyboard {
    public static void main(String[] args) {
        List<String> keyboard = getStrings();

        Map<String, Integer> keyboardIndexMap = new HashMap<>();

        for(int i =0;i<keyboard.size();i++) {
            keyboardIndexMap.put(keyboard.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String mode=sc.next();
        String s =sc.next();//"s;;upimrrfod;pbr";

        for(int i=0;i<s.length();i++) {
            sb.append(keyboard.get("R".equals(mode) ? keyboardIndexMap.get(""+s.charAt(i)) -1: keyboardIndexMap.get(""+s.charAt(i)) + 1));
        }

        System.out.println(sb.toString());
    }

    private static List<String> getStrings() {
        List<String> keyboard = new ArrayList<>();
        keyboard.add("q");
        keyboard.add("w");
        keyboard.add("e");
        keyboard.add("r");
        keyboard.add("t");
        keyboard.add("y");
        keyboard.add("u");
        keyboard.add("i");
        keyboard.add("o");
        keyboard.add("p");
        keyboard.add("a");
        keyboard.add("s");
        keyboard.add("d");
        keyboard.add("f");
        keyboard.add("g");
        keyboard.add("h");
        keyboard.add("j");
        keyboard.add("k");
        keyboard.add("l");
        keyboard.add(";");
        keyboard.add("z");
        keyboard.add("x");
        keyboard.add("c");
        keyboard.add("v");
        keyboard.add("b");
        keyboard.add("n");
        keyboard.add("m");
        keyboard.add(",");
        keyboard.add(".");
        keyboard.add("/");
        return keyboard;
    }
}
