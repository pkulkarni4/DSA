package others;

public class RecordTest {
    public static void main(String[] args) {
        Customer c1 = new Customer("Fred", "1000");
        Customer c3 = new Customer("Freddy", "1000");
        Customer c2 = new Customer("Fred", "1000");
        c1.print();
        System.out.println(c1);

    }
}
interface  FirstNameable{
    String first();
    String last();
    void print();
}
record Customer(String first, String last) implements FirstNameable {
    Customer(String first, String last){
        this.first = first;
        this.last = last;
    }

    public String toString(){
        return "first : " + this.first + " last: " + last;
    }

    public void print(){
        System.out.println("first : " + this.first + " last: " + last);
    }
}