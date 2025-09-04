package others;

class Parent{
    public int x = 99;
}
interface intWithStatic {
    static void method(){
        System.out.println("static in interface");
    }
    default void method2(){
        System.out.println("default method 2");
    }
}

class intWithStaticImpl implements intWithStatic{
    static void method(){
        System.out.println("static in interface");
    }

}

public class InstanceField extends Parent {
    int x = 200;
    public void go() {
        intWithStatic.method();
        System.out.println("InstanceField's x : "+x);
        System.out.println("Parent's x : "+super.x);
        Parent p = this;
        System.out.println("P.x: " +p.x);
        System.out.println("x: " +this.x);
        InstanceField instanceField = this;
        System.out.println("instanceField.x: " +instanceField.x);

        char[] chars = new char[]{'a','b','c'};
        String str = new String(chars);
        System.out.println(str);
        chars[0]='d';
        System.out.println(str);
    }

    public static void main(String[] args) {
        InstanceField iField = new InstanceField();
        iField.go();
    }
}

class Stuff {
    static void doStuff() {}
    void go() {
        new Stuff().doStuff();
    }
}
