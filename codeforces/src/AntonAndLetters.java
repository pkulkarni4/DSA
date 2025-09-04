import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AntonAndLetters {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for(char ch : input.toCharArray()){
            if(ch >= 'a' && 'z' >= ch){
                set.add(ch);
            }
        }
        System.out.println(set.size());
    }
}
