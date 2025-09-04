package others;

public class Outer {
    private int outerX=33;

    public static void main(String[] args) {
        new A2().doStuff();
    }
    interface nestedInt {
        void show();
    }
    void printX(){
        System.out.println(outerX);
    }

    class Nested1 implements nestedInt{
        private int nested1X;
        public void show() {
            Nested2 n2 = new Nested2();
            System.out.println(outerX);
            System.out.println(n2.nested2X);
            class cl {
                int x;
            }
            interface metd{}
            printX();
        }
    }
    class Nested2 implements nestedInt{
        private int nested2X;
        public void show() {
            Nested1 n1 = new Nested1();
            System.out.println(outerX);
            System.out.println(n1.nested1X);
            printX();
        }
    }
}

interface testIntt{
    default void doStuff(){}
    void doOtherStuff();
}

interface IV {
    default void doStuff(){

    }
}

interface IW {
    default void doStuff(){}
}

class A2 implements IW, IV {


    @Override
    public void doStuff() {
        IW.super.doStuff();
        IV.super.doStuff();
    }
}