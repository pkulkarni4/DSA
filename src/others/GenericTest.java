package others;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List names = new ArrayList<>(List.of( "Jim"));



        Pair<String, String> pair = new Pair<>("left", "Right");
        Integer ii = 4;
        Double i2 = 4d;
        Integer i3 = 4;
        List<? super Integer> li = new ArrayList<>();
        li.add(ii);
        //li.add(i2);
        li.add(i3);

        addNumbers(li);

       // sendEmails();
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            Integer ii = (Integer) list.get(i);
            System.out.println(ii.doubleValue());
        }
    }
}

class TestUpperBound<E extends String> {

}
class Pair<K extends Comparable<K>  & Serializable, V extends Comparable<V> & Serializable>{
    private K left;
    private V right;
    public Pair(K left, V right){
        this.left = left;
        this.right = right;
    }

    public void order() {

    }

    public static <U> void doStuff( U u) {}
}

class User {
    private int id;
    private String email;
    private String type;

}
class Operator extends User {

}
class CustomerNew extends User{

}